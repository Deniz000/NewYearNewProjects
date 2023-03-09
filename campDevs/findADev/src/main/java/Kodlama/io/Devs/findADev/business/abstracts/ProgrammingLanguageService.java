package Kodlama.io.Devs.findADev.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllLanguagesResponse> getAll();
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
}
