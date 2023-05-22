package dev.guldeniz.cv.business.abstracts.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.dtos.responses.JobSeekerResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface JobSeekerService {
	
	DataResult<List<JobSeekerResponse>> getAll();
	Result add(CreateJobSeekeerRequest jobSeekerRequest) throws Exception;
	

}
