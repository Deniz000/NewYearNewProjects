package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.business.abstracts.JobSeekerService;
import dev.guldeniz.cv.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService{
	
	private IdentityValidationService identityValidationService;

	@Override
	public void add(JobSeeker jobSeeker) throws Exception {
		if(identityValidationService.validateIdentity(jobSeeker)) {
			System.out.println("kaydedildi");
		}else {
			throw new Exception("Hata. Kaydolmadı!");
		}
	}

}
