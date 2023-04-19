package dev.guldeniz.cv.business.concretes.employer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.EmployerService;
import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.responses.GetAllEmployerResponse;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;
import dev.guldeniz.cv.business.rules.EmployerBusinessRules;
import dev.guldeniz.cv.dataAccess.abstracts.EmployerRepository;
import dev.guldeniz.cv.entities.concretes.Employer;
import dev.guldeniz.cv.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService{

	//private EmployerRepository employerRepository;
	private EmployerBusinessRules employerBusinessRules;
	private SystemStaffService staffSevice;
	private EmailService emailService;
	private EmployerRepository employerRepository;
	

	@Override
	public List<GetAllEmployerResponse> getAll() {
		List<Employer> employers = this.employerRepository.findAll();
		List<GetAllEmployerResponse> responses = new ArrayList<>();
		for(Employer js : employers) {
			//map kodları
		}
		return responses;
	}
	
	
	@Override
	public void add(CreateEmployerRequest employerRequest) throws Exception {
		//email adresinin olup olmadığını kontrol eder. Varsa haa dönecek ve kayıt gerçekleşmeyecek.
		this.employerBusinessRules.checkIfEMailExist(employerRequest.getEMail());
		
		//email domini ile domain eşleşti mi bakar. Eşleşmediyse hata fırlatır. Kaydolmaz. 
		this.employerBusinessRules.checkIfEMailMatch(employerRequest.getEMail(), employerRequest.getWebAddress());
		
		//sifre hashlemesi
		String salt = EmployerBusinessRules.generateSalt();
		EmployerBusinessRules.hashPassword(employerRequest.getPassword(), salt);
		
		//mapleme ile employer class'a çevrilir 
		
		String verificationCode = this.emailService.generateVerificationCode();
		this.emailService.sendEmail(employerRequest.getEMail(), "Email Doğrulama", "Doğrulama kodunuz:" + verificationCode);
		
		//Sistem personeli onayı
		if(!staffSevice.approveEmployer(employerRequest)) {
			throw new Exception("Kullanıcı onaylanmadı. (HRSM Reddi)");
		}
		
	}

}
