package dev.guldeniz.cv.business.abstracts;

import dev.guldeniz.cv.business.dtos.requests.CreateEmployerRequest;

public interface SystemStaffService {
	boolean approveEmployer(CreateEmployerRequest employerRequest);


}
