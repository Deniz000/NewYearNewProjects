package dev.guldeniz.cv.adapters;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;

@Service
public class MerniseServiceAdapter implements IdentityValidationService{

	// service aldık dışardan. Adapte etmek için adapter kullandık
	@Override
	public boolean validateIdentity(CreateJobSeekeerRequest jobSeekerRequest) {
		//mernis kodları
		return true;
	}

}
