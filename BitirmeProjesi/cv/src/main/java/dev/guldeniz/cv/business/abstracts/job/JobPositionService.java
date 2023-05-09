package dev.guldeniz.cv.business.abstracts.job;

import java.util.List;

import dev.guldeniz.cv.business.dtos.JobPositionsDto;
import dev.guldeniz.cv.business.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPositionsDto>> getAll();
	
	DataResult<List<JobPositionsDto>> getAllSorted();

	DataResult<List<JobPositionsDto>> getAll(int pageNumber, int pageSize);

	Result add(CreateJobPositionRequest jobPositionRequest);

	DataResult<JobPosition> getByPositionName(String positionName);

	DataResult<List<JobPosition>> getByPositionNameStartsWith(String positionName);

	DataResult<List<JobPosition>> getByPositionNameContains(String positionName);

}
