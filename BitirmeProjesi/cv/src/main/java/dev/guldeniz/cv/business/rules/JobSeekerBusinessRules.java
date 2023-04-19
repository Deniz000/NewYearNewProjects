package dev.guldeniz.cv.business.rules;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.dataAccess.abstracts.JobSeekerRepository;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class JobSeekerBusinessRules {
	
	private JobSeekerRepository jobSeekerRepository;
	
	public void checkIfEmailExist(String email) throws Exception {
		if(jobSeekerRepository.existsByEMail(email)) {
			throw new Exception("Bu email zaten kayıtlı");
		}
	}
	public void checkIfNationalIdentityExists(String id) throws Exception {
		if(this.jobSeekerRepository.existsByNationalIdentity(id)) {
			throw new Exception("Bu Tc kimlik no zaten kayıtlı");
		}
	}
	
//
//	// EMail geçerli mi değil mi
//	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//
//	public boolean isValid(String email) {
//		Matcher matcher = pattern.matcher(email);
//		return matcher.matches();
//	}
//
//	public void checkIfEMailExist(String email) throws Exception {
//		if (this.jobSeekerRepository.existsByEMail(email)) {
//			throw new Exception("bu mail adresi zaten kayıtlı! ");
//		}
//	}
}
