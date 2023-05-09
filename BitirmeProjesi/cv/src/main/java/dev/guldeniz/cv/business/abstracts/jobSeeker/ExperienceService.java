package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.requests.CreateExperienceRequest;
import dev.guldeniz.cv.core.results.Result;

public interface ExperienceService {
	public Result add(CreateExperienceRequest experienceRequenst); 

}
