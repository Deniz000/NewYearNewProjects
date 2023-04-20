package dev.guldeniz.cv.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.JobPositionService;
import dev.guldeniz.cv.business.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPositionsResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.dataAccess.abstracts.JobPositionRepository;
import dev.guldeniz.cv.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service 
@NoArgsConstructor
@AllArgsConstructor
public class JobPositionManager implements JobPositionService{

	private JobPositionRepository positionRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllJobPositionsResponse> getAll() {
		List<JobPosition> positions = this.positionRepository.findAll();
		List<GetAllJobPositionsResponse> responses = positions.stream()
				.map(position -> this.modelMapperService.forResponse()
						.map(positions, GetAllJobPositionsResponse.class)).collect(Collectors.toList());
		return responses;
	}
	@Override
	public void add(CreateJobPositionRequest jobPositionRequest) {
		JobPosition position = this.modelMapperService.forRequest().map(jobPositionRequest, JobPosition.class);
		this.positionRepository.save(position);
	}
}
