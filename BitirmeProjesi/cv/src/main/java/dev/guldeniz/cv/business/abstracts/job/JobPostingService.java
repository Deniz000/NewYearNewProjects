package dev.guldeniz.cv.business.abstracts.job;

import java.util.List;

import dev.guldeniz.cv.business.dtos.JobPostingFilterDto;
import dev.guldeniz.cv.business.dtos.JobPostingDto;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto;

public interface JobPostingService {
	Result add(CreateJobPostingRequest postingRequest);
	Result deactivateJobPostingById(int postingId);
	DataResult<List<JobPostingDto>> getAll();
	DataResult<List<JobPostingDto>> getAllSorted();
    DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrue();
    DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateDesc();
    DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateAsc();
    DataResult<List<JobPostingFilterDto>> findAllByIsActiveAndCompanyName(String companyName);
    DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail();
	
}
