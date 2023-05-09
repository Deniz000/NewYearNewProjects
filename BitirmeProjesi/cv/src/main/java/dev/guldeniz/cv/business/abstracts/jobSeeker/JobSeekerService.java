package dev.guldeniz.cv.business.abstracts.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.business.dtos.JobSeekerDto;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface JobSeekerService {
	
	DataResult<List<JobSeekerDto>> getAll();
	Result add(CreateJobSeekeerRequest jobSeekerRequest) throws Exception;
	

}
