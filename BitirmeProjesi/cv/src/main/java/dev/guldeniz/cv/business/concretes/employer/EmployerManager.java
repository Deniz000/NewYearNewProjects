package dev.guldeniz.cv.business.concretes.employer;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmployerService;
import dev.guldeniz.cv.business.rules.EmployerBusinessRules;
import dev.guldeniz.cv.entities.concretes.Employer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService{

	private EmployerBusinessRules employerBusinessRules;
	@Override
	public void add(Employer employer) throws Exception {
		//email adresinin olup olmadığını kontrol eder. Varsa haa dönecek ve kayıt gerçekleşmeyecek.
		this.employerBusinessRules.checkIfEMailExist(employer.getEMail());
		
		//email domini ile domain eşleşti mi bakar. Eşleşmediyse hata fırlatır. Kaydolmaz. 
		this.employerBusinessRules.checkIfEMailMatch(employer.getEMail(), employer.getWebAddress());
		
	}

}
