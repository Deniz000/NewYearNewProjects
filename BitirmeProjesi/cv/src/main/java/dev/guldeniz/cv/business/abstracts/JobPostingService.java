package dev.guldeniz.cv.business.abstracts;

import java.util.List;

import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPostingFilterResponse;
import dev.guldeniz.cv.business.responses.GetAllJobPostingResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto;

public interface JobPostingService {
	Result add(CreateJobPostingRequest postingRequest);
	Result deactivateJobPostingById(int postingId);
	DataResult<List<GetAllJobPostingResponse>> getAll();
	DataResult<List<GetAllJobPostingResponse>> getAllSorted();
    DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrue();
    DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateDesc();
    DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateAsc();
    DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveAndCompanyName(String companyName);
    DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail();


	
}
