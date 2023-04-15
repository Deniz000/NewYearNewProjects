package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.business.abstracts.JobSeekerService;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.rules.JobSeekerBusinessRules;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService{
	
	private IdentityValidationService identityValidationService;
	private JobSeekerBusinessRules jobSeekerBusinessRules;

	@Override
	public void add(CreateJobSeekeerRequest jobSeekerRequuest) throws Exception {
		if(identityValidationService.validateIdentity(jobSeekerRequuest)) {
			System.out.println("kaydedildi");
		}else {
			throw new Exception("Hata. Kaydolmadı!");
		}
		
		// eposta geçerli mi değil mi? 
		this.jobSeekerBusinessRules.isValid(jobSeekerRequuest.getEPosta());
		
	}

}
