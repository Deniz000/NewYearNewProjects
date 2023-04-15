package dev.guldeniz.cv.business.abstracts;

import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;

public interface JobSeekerService {
	
	void add(CreateJobSeekeerRequest jobSeekerRequest) throws Exception;
	

}
