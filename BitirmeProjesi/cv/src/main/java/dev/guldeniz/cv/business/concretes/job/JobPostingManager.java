package dev.guldeniz.cv.business.concretes.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.JobPostingService;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPostingFilterResponse;
import dev.guldeniz.cv.business.responses.GetAllJobPostingResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobPostingRepository;
import dev.guldeniz.cv.entities.concretes.JobPosting;
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
	public DataResult<List<GetAllJobPostingResponse>> getAll() {
		List<JobPosting> postings = this.jobPositingRepository.findAll();
		List<GetAllJobPostingResponse> responses = postings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingResponse.class))
				.collect(Collectors.toList());
		System.out.println(responses.get(0).getCompanyName());
		return new SuccessDataResult<List<GetAllJobPostingResponse>>(responses, "Data Listelendi");
	}
//Sort ile sıralam yapıyor
//	@Override
//	public DataResult<List<GetAllJobPostingResponse>> getAllSorted() {
//		Sort sort = Sort.by(Sort.Direction.DESC, "publishDate");
//		List<JobPosting> postings = this.jobPositingRepository.findAll(sort);
//		List<GetAllJobPostingResponse> responses = postings.stream()
//				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingResponse.class))
//				.collect(Collectors.toList());
//		System.out.println(responses.get(0).getCompanyName());
//		return new SuccessDataResult<List<GetAllJobPostingResponse>>(responses, "Data Listelendi");
//	}

	@Override
	public DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrue() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrue();
		;
		List<GetAllJobPostingFilterResponse> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingFilterResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllJobPostingFilterResponse>>(responses,
				"Active job postings are listed.");
	}

	@Override
	public DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateDesc() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrueOrderByPublishDateDesc();
		List<GetAllJobPostingFilterResponse> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingFilterResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllJobPostingFilterResponse>>(responses,
				"Active job postings are listed by desc.");
	}

	@Override
	public DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateAsc() {
		List<JobPosting> jobPostings = this.jobPositingRepository.findAllByIsActiveTrueOrderByPublishDateAsc();
		List<GetAllJobPostingFilterResponse> responses = jobPostings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingFilterResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllJobPostingFilterResponse>>(responses,
				"Active job postings are listed by asc.");
	}

	@Override
	public DataResult<List<GetAllJobPostingResponse>> getAllSorted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<GetAllJobPostingFilterResponse>> findAllByIsActiveAndCompanyName(String companyName) {
		List<JobPosting> postings = this.jobPositingRepository.findAllByIsActiveAndCompanyName(companyName);
		List<GetAllJobPostingFilterResponse> responses = postings.stream()
				.map(p -> this.modelMapperService.forResponse().map(p, GetAllJobPostingFilterResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobPostingFilterResponse>>(responses,
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
		List<JobPosting> postings = this.jobPositingRepository.getJobPostingWithEmployerDetail();
		List<JobPostingWithEmployerDto> reponses = postings.stream()
				.map(p -> this.modelMapperService.forResponse()
						.map(p, JobPostingWithEmployerDto.class)).collect(Collectors.toList());
		System.out.print("2");

		return new SuccessDataResult<List<JobPostingWithEmployerDto>>(reponses, "Data s");
	}
}
