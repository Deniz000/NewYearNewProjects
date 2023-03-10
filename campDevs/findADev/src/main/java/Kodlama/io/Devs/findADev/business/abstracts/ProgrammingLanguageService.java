package Kodlama.io.Devs.findADev.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	List<GetAllLanguagesResponse> getAll();
	public GetAllLanguagesResponse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void delete(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
}
