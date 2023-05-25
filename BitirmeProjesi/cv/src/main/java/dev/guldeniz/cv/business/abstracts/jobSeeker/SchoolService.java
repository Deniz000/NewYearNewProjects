package dev.guldeniz.cv.business.abstracts.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateSchoolRequest;
import dev.guldeniz.cv.business.dtos.responses.SchoolResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface SchoolService {
	public Result add(CreateSchoolRequest schoolRequest);
	public DataResult<List<SchoolResponse>> getAll();

}
