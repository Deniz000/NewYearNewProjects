package dev.guldeniz.cv.business.concretes.systemStaff;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.entities.abstracts.User;
import dev.guldeniz.cv.entities.concretes.Employer;

@Service
public class SystemStaffManager implements SystemStaffService{

	@Override
	public boolean approveEmployer(CreateEmployerRequest employerRequest) {
		User employer = new Employer();
		employer.setActive(true);
		employer.setVerified(true);
		//onaylama kodları
		return true;
	}

}
