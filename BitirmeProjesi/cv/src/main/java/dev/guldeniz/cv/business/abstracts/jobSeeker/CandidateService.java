package dev.guldeniz.cv.business.abstracts.jobSeeker;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.business.dtos.responses.CandidateResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;

public interface CandidateService {
	public DataResult<List<CandidateResponse>> getAll();
	public Result add(CreateCandidateRequest candaidateRequest);

}
