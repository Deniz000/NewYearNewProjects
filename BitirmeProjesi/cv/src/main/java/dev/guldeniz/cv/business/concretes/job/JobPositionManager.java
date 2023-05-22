package dev.guldeniz.cv.business.concretes.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.job.JobPositionService;
import dev.guldeniz.cv.business.dtos.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.dtos.responses.JobPositionsResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobPositionRepository;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionManager implements JobPositionService {

	private JobPositionRepository positionRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<JobPositionsResponse>> getAll() {
		List<JobPosition> positions = this.positionRepository.findAll();

		List<JobPositionsResponse> responses = positions.stream()
				.map(position -> this.modelMapperService.forResponse().map(position, JobPositionsResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<JobPositionsResponse>>(responses, "Data Listelendi");
	}

	@Override
	public Result add(CreateJobPositionRequest jobPositionRequest) {
		JobPosition position = this.modelMapperService.forRequest().map(jobPositionRequest, JobPosition.class);
		this.positionRepository.save(position);
		return new SuccessResult("İş Pozisyonu Eklendi!");
	}

	@Override
	public DataResult<JobPosition> getByPositionName(String positionName) {
		// business codes
		return new SuccessDataResult<JobPosition>(this.positionRepository.getByPositionName(positionName),
				"Data Listelendi");

	}

	@Override
	public DataResult<List<JobPosition>> getByPositionNameStartsWith(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(
				this.positionRepository.getByPositionNameStartsWith(positionName), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPosition>> getByPositionNameContains(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(this.positionRepository.getByPositionNameContains(positionName),
				"Data Listelendi");

	}

	@Override
	public DataResult<List<JobPositionsResponse>> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		Page<JobPosition> pages = this.positionRepository.findAll(pageable);
		List<JobPositionsResponse> responses = pages.stream()
				.map(page -> this.modelMapperService.forResponse()
						.map(page, JobPositionsResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<JobPositionsResponse>>(responses,"Data");
	}

	@Override
	public DataResult<List<JobPositionsResponse>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "positionName");
		List<JobPosition> sorted = this.positionRepository.findAll(sort);
		List<JobPositionsResponse> responses = sorted.stream()
				.map(s -> this.modelMapperService.forResponse()
						.map(s, JobPositionsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobPositionsResponse>>(responses,"Data Listelendi!");
	}
}
