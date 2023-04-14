package dev.guldeniz.cv.adapters;

import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.entities.abstracts.User;

public class MerniseServiceAdapter implements IdentityValidationService{

	// service aldık dışardan. Adapte etmek için adapter kullandık
	@Override
	public boolean validateIdentity(User user) {
		//mernis kodları
		return true;
	}

}
