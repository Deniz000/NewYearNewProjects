package dev.guldeniz.cv.business.abstracts.jobSeeker;

import dev.guldeniz.cv.business.requests.CreateProgrammingLanguageRequest;
import dev.guldeniz.cv.core.results.Result;

public interface ProgrammingLanguageService {
	public Result add(CreateProgrammingLanguageRequest languageRequest);
}
