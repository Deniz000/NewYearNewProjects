package dev.guldeniz.cv.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import io.micrometer.common.util.StringUtils;

@Service
public class EmailManager implements EmailService{

	@Override
	public void sendEmail(String to, String subject, String body) {
		// Result yazılabilir burada daha sonra 
		//şimdilik şöyle
		System.out.println("Kayıt başarılı yazacak");
	}

	@Override
	public String generateVerificationCode() {
		// TODO Auto-generated method stub
		return "211743";
	}

	@Override
	public boolean isEmailValid(String email) {

		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
		if (StringUtils.isNotBlank(email)) {
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
		return false;
	}

}	//
//public void checkIfEMailExist(String email) throws Exception {
//if (this.jobSeekerRepository.existsByEMail(email)) {
//	throw new Exception("bu mail adresi zaten kayıtlı! ");
//}
//}
