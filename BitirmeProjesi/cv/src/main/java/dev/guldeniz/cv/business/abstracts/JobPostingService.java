package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPostingResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface JobPostingService {
	Result add(CreateJobPostingRequest postingRequest);
	DataResult<List<GetAllJobPostingResponse>> getAll();
	
}
