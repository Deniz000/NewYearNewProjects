package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.ProgrammingLanguageService;
import dev.guldeniz.cv.business.requests.CreateProgrammingLanguageRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.ProgrammingLanguageRepository;
import dev.guldeniz.cv.entities.concretes.jobSeeker.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository languageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateProgrammingLanguageRequest languageRequest) {
		ProgrammingLanguage language = this.modelMapperService.forRequest().map(languageRequest, ProgrammingLanguage.class);
		this.languageRepository.save(language);
				
		return new SuccessResult("Eklendi Çok Şükür;");
	}

}
