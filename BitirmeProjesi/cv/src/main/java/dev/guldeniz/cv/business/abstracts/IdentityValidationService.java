package dev.guldeniz.cv.business.abstracts;

import dev.guldeniz.cv.entities.abstracts.User;

public interface IdentityValidationService {
	boolean validateIdentity(User user);

}
