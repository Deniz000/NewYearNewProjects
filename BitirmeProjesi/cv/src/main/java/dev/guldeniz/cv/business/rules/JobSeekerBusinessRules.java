package dev.guldeniz.cv.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class JobSeekerBusinessRules {
	
	//private JobSeekerRepository jobSeekerRepository;
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
