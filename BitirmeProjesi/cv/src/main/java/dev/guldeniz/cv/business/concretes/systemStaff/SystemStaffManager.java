package dev.guldeniz.cv.business.concretes.systemStaff;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.SystemStaffService;
import dev.guldeniz.cv.business.dtos.requests.CreateEmployerRequest;

@Service
public class SystemStaffManager implements SystemStaffService{

	@Override
	public boolean approveEmployer(CreateEmployerRequest employerRequest) {
		//onaylama kodları
		return true;
	}

}
