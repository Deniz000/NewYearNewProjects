package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.core.results.Result;

public interface CandidateService {
	public Result add(CreateCandidateRequest candaidateRequest);

}
