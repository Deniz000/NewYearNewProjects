package dev.guldeniz.cv.business.abstracts;

import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import jakarta.validation.Valid;

public interface EmployerService {
	void add(@Valid CreateEmployerRequest employerReqest) throws Exception;

}
