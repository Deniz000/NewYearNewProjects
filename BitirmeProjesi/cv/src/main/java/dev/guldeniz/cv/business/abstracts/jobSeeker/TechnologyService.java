package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.requests.CreateTechnologyRequest;
import dev.guldeniz.cv.core.results.Result;

public interface TechnologyService {

	public Result add(CreateTechnologyRequest technologyRequest);
}
