package dev.guldeniz.cv.business.concretes.jobSeeker;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.ExperienceService;
import dev.guldeniz.cv.business.dtos.requests.CreateExperienceRequest;
import dev.guldeniz.cv.business.dtos.responses.ExperienceResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.ExperienceRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.Experience;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service 
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceManager implements ExperienceService{

	private ExperienceRepository experienceRepository;
	private ModelMapperService modelMapper;
	@Override
	public Result add(CreateExperienceRequest experienceRequenst) {
		Experience experience = this.modelMapper.forRequest().map(experienceRequenst, Experience.class);
		this.experienceRepository.save(experience);
		return new SuccessResult("Eklendi Koş Bak :)");
	}
	@Override
	public DataResult<List<ExperienceResponse>> getAll() {
		List<Experience> experiences = this.experienceRepository.findAll();
		List<ExperienceResponse> responses = experiences.stream()
				.map(experience -> this.modelMapper.forResponse()
						.map(experience, ExperienceResponse.class)).collect(Collectors.toList());;
		return new SuccessDataResult<List<ExperienceResponse>>(responses, "Data Listelendi!");
	}
	

}
