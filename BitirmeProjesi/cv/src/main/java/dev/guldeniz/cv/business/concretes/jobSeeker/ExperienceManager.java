package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.ExperienceService;
import dev.guldeniz.cv.business.requests.CreateExperienceRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.ExperienceRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.Experience;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class ExperienceManager implements ExperienceService{

	private ExperienceRepository experienceRepository;
	private ModelMapperService modelMapper;
	@Override
	public Result add(CreateExperienceRequest experienceRequenst) {
		Experience experience = this.modelMapper.forRequest().map(experienceRequenst, Experience.class);
		this.experienceRepository.save(experience);
		return new SuccessResult("Eklendi Koş Bak :)");
	}

}
