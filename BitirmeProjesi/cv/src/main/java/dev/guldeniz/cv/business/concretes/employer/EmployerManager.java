package dev.guldeniz.cv.business.concretes.employer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.abstracts.employer.EmployerService;
import dev.guldeniz.cv.business.dtos.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.dtos.responses.EmployerResponse;
import dev.guldeniz.cv.business.rules.EmployerBusinessRules;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.EmployerRepository;
import dev.guldeniz.cv.entities.concretes.employer.Employer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService{

	//private EmployerRepository employerRepository;
	private EmployerBusinessRules employerBusinessRules;
	private SystemStaffService staffSevice;
	private EmailService emailService;
	private EmployerRepository employerRepository;
	private ModelMapperService modelMapperService;
	

	@Override
	public DataResult<List<EmployerResponse>> getAll() {
		List<Employer> employers = this.employerRepository.findAll();
		List<EmployerResponse> responses = employers.stream()
				.map(employer -> this.modelMapperService.forResponse()
						.map(employer, EmployerResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<EmployerResponse>>(
				responses,"Data Listelendi!");
	}
	
	
	//    @Transactional  eklenmeli
	@Override
	public Result add(CreateEmployerRequest employerRequest) throws Exception {
		//email adresinin kayıtlı olup olmadığını kontrol eder. Varsa haa dönecek ve kayıt gerçekleşmeyecek.
		this.employerBusinessRules.checkIfEMailExist(employerRequest.getEMail());
		
		//email domini ile domain eşleşti mi bakar. Eşleşmediyse hata fırlatır. Kaydolmaz. 
		this.employerBusinessRules.checkIfEMailMatch(employerRequest.getEMail(), employerRequest.getWebAddress());
		
		//sifreyi hashliyoruz
//		String salt = PasswordRules.generateSalt();
//		PasswordRules.hashPassword(employerRequest.getPassword(), salt);
		//sonra kaydediyoruz
		//mapleme ile employer class'a çevrilir 
		
		  PropertyMap<CreateEmployerRequest, Employer> employerMap = new PropertyMap<CreateEmployerRequest, Employer>() {
		        protected void configure() {
		        	map().setPasswordHash(source.getPassword());
//		        	map().setPasswordHash(null);// Skip the 'confirmPassword' field
		        }
		    };
		    this.modelMapperService.forRequest().addMappings(employerMap);

		Employer employer = this.modelMapperService.forRequest().map(employerRequest, Employer.class);
		//propertymap içinde yapılabilir :
		employer.setActive(true); 
		employer.setVerified(true);
		this.employerRepository.save(employer);
 		 
		String verificationCode = this.emailService.generateVerificationCode();
		this.emailService.sendEmail(employerRequest.getEMail(), "Email Doğrulama", "Doğrulama kodunuz:" + verificationCode);
		
		//Sistem personeli onayı
		if(!staffSevice.approveEmployer(employerRequest)) {
			throw new Exception("Kullanıcı onaylanmadı. (HRSM Reddi)");
		}
		return new SuccessResult("Kayıt Başarılı!");
	}

}
