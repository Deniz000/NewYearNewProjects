package dev.guldeniz.cv.business.concretes.employer;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.EmployerService;
import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.rules.EmployerBusinessRules;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService{

	//private EmployerRepository employerRepository;
	private EmployerBusinessRules employerBusinessRules;
	private SystemStaffService staffSevice;
	private EmailService emailService;
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
