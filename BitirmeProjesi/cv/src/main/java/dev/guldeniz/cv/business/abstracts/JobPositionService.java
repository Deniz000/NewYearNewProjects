package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPositionsResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<GetAllJobPositionsResponse>> getAll();
	
	DataResult<List<GetAllJobPositionsResponse>> getAllSorted();

	DataResult<List<GetAllJobPositionsResponse>> getAll(int pageNumber, int pageSize);

	Result add(CreateJobPositionRequest jobPositionRequest);

	DataResult<JobPosition> getByPositionName(String positionName);

	DataResult<List<JobPosition>> getByPositionNameStartsWith(String positionName);

	DataResult<List<JobPosition>> getByPositionNameContains(String positionName);

}
