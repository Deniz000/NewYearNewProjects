package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface JobSeekerService {
	
	DataResult<List<GetAllJobSeekerResponse>> getAll();
	Result add(CreateJobSeekeerRequest jobSeekerRequest) throws Exception;
	

}
