package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPositionsResponse;

public interface JobPositionService {
	List<GetAllJobPositionsResponse> getAll();
	void add(CreateJobPositionRequest jobPositionRequest);
}
