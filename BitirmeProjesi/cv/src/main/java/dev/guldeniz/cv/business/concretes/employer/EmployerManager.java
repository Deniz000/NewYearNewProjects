package dev.guldeniz.cv.business.concretes.employer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.EmployerService;
import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.responses.GetAllEmployerResponse;
import dev.guldeniz.cv.business.rules.EmployerBusinessRules;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.dataAccess.abstracts.EmployerRepository;
import dev.guldeniz.cv.entities.concretes.Employer;
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
	public List<GetAllEmployerResponse> getAll() {
		List<Employer> employers = this.employerRepository.findAll();
		List<GetAllEmployerResponse> responses = employers.stream()
				.map(employer -> this.modelMapperService.forResponse()
						.map(employer, GetAllEmployerResponse.class)).collect(Collectors.toList());
		return responses;
	}
	
	
	//    @Transactional  eklenmeli
	@Override
	public void add(CreateEmployerRequest employerRequest) throws Exception {
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
		employer.setActive(true); 
		employer.setVerified(true);
		this.employerRepository.save(employer);
 		 
		String verificationCode = this.emailService.generateVerificationCode();
		this.emailService.sendEmail(employerRequest.getEMail(), "Email Doğrulama", "Doğrulama kodunuz:" + verificationCode);
		
		//Sistem personeli onayı
		if(!staffSevice.approveEmployer(employerRequest)) {
			throw new Exception("Kullanıcı onaylanmadı. (HRSM Reddi)");
		}
	}

}
