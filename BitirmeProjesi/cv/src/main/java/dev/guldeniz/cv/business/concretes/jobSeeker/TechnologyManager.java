package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.TechnologyService;
import dev.guldeniz.cv.business.dtos.requests.CreateTechnologyRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.TechnologyRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService{
	private TechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateTechnologyRequest technologyRequest) {
		Technology technology = this.modelMapperService.forRequest().map(technologyRequest, Technology.class);
		this.technologyRepository.save(technology);
		return new SuccessResult("İşlem Okey");
	}

}
