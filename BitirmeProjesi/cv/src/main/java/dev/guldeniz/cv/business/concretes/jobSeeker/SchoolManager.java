package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.SchoolService;
import dev.guldeniz.cv.business.dtos.requests.CreateSchoolRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.SchoolRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.School;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SchoolManager implements SchoolService{
	private ModelMapperService modelMapper;
	private SchoolRepository schoolRepository;
	
	@Override
	public Result add(CreateSchoolRequest schoolRequest) {
		School school = this.modelMapper.forRequest().map(schoolRequest, School.class);
		this.schoolRepository.save(school);
		return new SuccessResult("Okul eklendi");
	}

}
