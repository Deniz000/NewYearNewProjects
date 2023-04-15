package dev.guldeniz.cv.business.rules;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class JobSeekerBusinessRules {
	
	//EMail geçerli mi değil mi 
	 private static final String EMAIL_PATTERN =
	            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	    public boolean isValid(String email) {
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
}
