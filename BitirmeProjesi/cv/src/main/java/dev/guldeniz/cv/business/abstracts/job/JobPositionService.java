package dev.guldeniz.cv.business.abstracts.job;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.dtos.responses.JobPositionsResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPositionsResponse>> getAll();
	
	DataResult<List<JobPositionsResponse>> getAllSorted();

	DataResult<List<JobPositionsResponse>> getAll(int pageNumber, int pageSize);

	Result add(CreateJobPositionRequest jobPositionRequest);

	DataResult<JobPosition> getByPositionName(String positionName);

	DataResult<List<JobPosition>> getByPositionNameStartsWith(String positionName);

	DataResult<List<JobPosition>> getByPositionNameContains(String positionName);

}
