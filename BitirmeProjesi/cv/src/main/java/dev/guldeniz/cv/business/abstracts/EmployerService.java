package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.responses.GetAllEmployerResponse;
import jakarta.validation.Valid;

public interface EmployerService {
	List<GetAllEmployerResponse> getAll();
	void add(@Valid CreateEmployerRequest employerReqest) throws Exception;

}
