package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.dtos.requests.CreateTechnologyRequest;
import dev.guldeniz.cv.core.results.Result;

public interface TechnologyService {

	public Result add(CreateTechnologyRequest technologyRequest);
}
