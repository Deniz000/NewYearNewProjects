package dev.guldeniz.cv.business.abstracts;

import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;

public interface IdentityValidationService {
	boolean validateIdentity(CreateJobSeekeerRequest jobSeeker);

}
