package dev.guldeniz.cv.business.concretes.systemStaff;

import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;

public class SystemStaffManager implements SystemStaffService{

	@Override
	public boolean approveEmployer(CreateEmployerRequest employerRequest) {
		//onaylama kodları
		return true;
	}

}
