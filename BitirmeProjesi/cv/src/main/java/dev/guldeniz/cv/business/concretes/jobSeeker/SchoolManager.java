package dev.guldeniz.cv.business.concretes.jobSeeker;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.SchoolService;
import dev.guldeniz.cv.business.dtos.requests.CreateSchoolRequest;
import dev.guldeniz.cv.business.dtos.responses.SchoolResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.SchoolRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.School;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolManager implements SchoolService{
	private ModelMapperService modelMapper;
	private SchoolRepository schoolRepository;
	
	@Override
	public Result add(CreateSchoolRequest schoolRequest) {
		PropertyMap<CreateSchoolRequest, School> schoolMap = new PropertyMap<CreateSchoolRequest, School>(){
			@Override
			protected void configure() {
				map().getCandidate().setId(source.getCandidateId());
			}	
		};
		this.modelMapper.forRequest().addMappings(schoolMap);
		School school = this.modelMapper.forRequest().map(schoolRequest, School.class);
		this.schoolRepository.save(school);
		return new SuccessResult("Okul eklendi");
	}

	public DataResult<List<SchoolResponse>> getAll(){
		List<School> schools = this.schoolRepository.findAll();
		List<SchoolResponse> responses = schools.stream()
				.map(s->this.modelMapper.forResponse()
						.map(s, SchoolResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<SchoolResponse>>(responses, "Data Listelendi");
	}
}
