package Kodlama.io.Devs.findADev.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllLanguagesResponse> getAll();
	public GetAllLanguagesResponse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
}
