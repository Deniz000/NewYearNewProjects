package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;

public interface JobSeekerService {
	
	List<GetAllJobSeekerResponse> getAll();
	void add(CreateJobSeekeerRequest jobSeekerRequest) throws Exception;
	

}
