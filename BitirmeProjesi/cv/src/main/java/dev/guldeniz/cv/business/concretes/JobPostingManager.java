package dev.guldeniz.cv.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.JobPostingService;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPostingResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobPostingRepository;
import dev.guldeniz.cv.entities.concretes.JobPosting;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobPostingManager implements JobPostingService{
	private JobPostingRepository jobPositingRepository;
	private ModelMapperService modelMapperService;


	@Override
	public Result add(CreateJobPostingRequest postingRequest) {
		JobPosting jobPosting = this.modelMapperService.forRequest().map(postingRequest, JobPosting.class);
		this.jobPositingRepository.save(jobPosting);
		return new SuccessResult("Data Eklendi");
	}


	@Override
	public DataResult<List<GetAllJobPostingResponse>> getAll() {
		List<JobPosting> postings = this.jobPositingRepository.findAll();
		List<GetAllJobPostingResponse> responses = postings.stream()
				.map(p -> this.modelMapperService.forResponse()
						.map(p, GetAllJobPostingResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobPostingResponse>>(responses, "Data Listelendi");
	}

	
}
