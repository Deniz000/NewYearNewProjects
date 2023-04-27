package dev.guldeniz.cv.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.JobPositionService;
import dev.guldeniz.cv.business.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPositionsResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobPositionRepository;
import dev.guldeniz.cv.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobPositionManager implements JobPositionService {

	private JobPositionRepository positionRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllJobPositionsResponse>> getAll() {
		List<JobPosition> positions = this.positionRepository.findAll();

		List<GetAllJobPositionsResponse> responses = positions.stream()
				.map(position -> this.modelMapperService.forResponse()
						.map(position, GetAllJobPositionsResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllJobPositionsResponse>>(responses, "Data Listelendi");
	}

	@Override
	public Result add(CreateJobPositionRequest jobPositionRequest) {
		JobPosition position = this.modelMapperService.forRequest().map(jobPositionRequest, JobPosition.class);
		this.positionRepository.save(position);
		return new SuccessResult("İş Pozisyonu Eklendi!");
	}

	@Override
	public DataResult<JobPosition> getByPositionName(String positionName) {
		//business codes
		return new SuccessDataResult<JobPosition>(this.positionRepository.getByPositionName(positionName), "Data Listelendi");

	}

	@Override
	public DataResult<List<JobPosition>> getByPositionNameStartsWith(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(this.positionRepository.getByPositionNameStartsWith(positionName), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPosition>> getByPositionNameContains(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(this.positionRepository.getByPositionNameContains(positionName), "Data Listelendi");

	}
}
