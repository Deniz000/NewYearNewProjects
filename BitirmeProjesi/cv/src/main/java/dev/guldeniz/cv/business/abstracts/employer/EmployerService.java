package dev.guldeniz.cv.business.abstracts.employer;

import java.util.List;

import dev.guldeniz.cv.business.dtos.EmployerDto;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import jakarta.validation.Valid;

public interface EmployerService {
	DataResult<List<EmployerDto>> getAll();
	Result add(@Valid CreateEmployerRequest employerReqest) throws Exception;

}
