package dev.guldeniz.cv.business.abstracts.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateExperienceRequest;
import dev.guldeniz.cv.business.dtos.responses.ExperienceResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface ExperienceService { 
	public Result add(CreateExperienceRequest experienceRequenst); 
	public DataResult<List<ExperienceResponse>> getAll();

}
