package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.requests.CreateSchoolRequest;
import dev.guldeniz.cv.core.results.Result;

public interface SchoolService {
	public Result add(CreateSchoolRequest schoolRequest);

}
