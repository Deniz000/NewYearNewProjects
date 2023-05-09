package dev.guldeniz.cv.business.concretes.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.job.JobPostingService;
import dev.guldeniz.cv.business.dtos.JobPostingFilterDto;
import dev.guldeniz.cv.business.dtos.JobPostingDto;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobPostingRepository;
import dev.guldeniz.cv.entities.concretes.job.JobPosting;
import dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobPostingManager implements JobPostingService {
	
	private JobPostingRepository jobPositingRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateJobPostingRequest postingRequest) {

		JobPosting jobPosting = this.modelMapperService.forRequest().map(postingRequest, JobPosting.class);
		this.jobPositingRepository.save(jobPosting);

		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> getAll() {
		List<JobPosting> postings = this.jobPositingRepository.findAll();
		List<JobPostingDto> responses = postings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, JobPostingDto.class))
				.collect(Collectors.toList());
		System.out.println(responses.get(0).getCompanyName());
		return new SuccessDataResult<List<JobPostingDto>>(responses, "Data Listelendi");
	}
//	Sort sort = Sort.by(Sort.Direction.DESC, "publishDate");

	@Override
	public DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrue() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrue();
		;
		List<JobPostingFilterDto> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, JobPostingFilterDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<JobPostingFilterDto>>(responses,
				"Active job postings are listed.");
	}

	@Override
	public DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateDesc() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrueOrderByPublishDateDesc();
		List<JobPostingFilterDto> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, JobPostingFilterDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<JobPostingFilterDto>>(responses,
				"Active job postings are listed by desc.");
	}

	@Override
	public DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateAsc() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrueOrderByPublishDateAsc();
		List<JobPostingFilterDto> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, JobPostingFilterDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<JobPostingFilterDto>>(responses,
				"Active job postings are listed by asc.");
	}

	@Override
	public DataResult<List<JobPostingDto>> getAllSorted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingFilterDto>> findAllByIsActiveAndCompanyName(String companyName) {
		List<JobPosting> postings = this.jobPositingRepository.findAllByIsActiveAndCompanyName(companyName);
		List<JobPostingFilterDto> responses = postings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, JobPostingFilterDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobPostingFilterDto>>(responses,
				"Şirketin aktif ilanları listelendi!");
	}

	@Override
	public Result deactivateJobPostingById(int postingId) {
		JobPosting jobPosting = this.jobPositingRepository.findById(postingId).orElseThrow();
		jobPosting.setActive(false);
		this.jobPositingRepository.save(jobPosting);

		return new SuccessResult("İş ilanı kapatıldı!");
	}

	@Override
	public DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail() {
		System.out.print("1");
		List<JobPosting> postings = this.jobPositingRepository.findAll();
		List<JobPostingWithEmployerDto> reponses = postings.stream()
				.map(p -> this.modelMapperService.forResponse()
						.map(p, JobPostingWithEmployerDto.class)).collect(Collectors.toList());
		System.out.print("2");

		return new SuccessDataResult<List<JobPostingWithEmployerDto>>(reponses, "Data s");
	}
}
