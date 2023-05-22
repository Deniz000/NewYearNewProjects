package dev.guldeniz.cv.business.abstracts.job;

import java.util.List;

import dev.guldeniz.cv.business.dtos.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.dtos.responses.JobPostingResponse;
import dev.guldeniz.cv.business.dtos.responses.JobPostingFilterResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto;

public interface JobPostingService {
	Result add(CreateJobPostingRequest postingRequest);
	Result deactivateJobPostingById(int postingId);
	DataResult<List<JobPostingResponse>> getAll();
	DataResult<List<JobPostingResponse>> getAllSorted();
    DataResult<List<JobPostingFilterResponse>> findAllByIsActiveTrue();
    DataResult<List<JobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateDesc();
    DataResult<List<JobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateAsc();
    DataResult<List<JobPostingFilterResponse>> findAllByIsActiveAndCompanyName(String companyName);
    DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail();
	
}
