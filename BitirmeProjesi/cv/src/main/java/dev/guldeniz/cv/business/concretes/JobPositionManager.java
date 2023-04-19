package dev.guldeniz.cv.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.JobPositionService;
import dev.guldeniz.cv.dataAccess.abstracts.JobPositionRepository;
import dev.guldeniz.cv.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service 
@NoArgsConstructor
@AllArgsConstructor
public class JobPositionManager implements JobPositionService{

	private JobPositionRepository positionRepository;

	@Override
	public List<JobPosition> getAll() {
		// TODO Auto-generated method stub
		return this.positionRepository.findAll();
	}

	@Override
	public void add(JobPosition jobPosition) {
		this.positionRepository.save(jobPosition);		
	}


}
