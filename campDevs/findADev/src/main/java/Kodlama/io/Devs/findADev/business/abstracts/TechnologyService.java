package Kodlama.io.Devs.findADev.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.findADev.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {
	
	List<GetAllTechnologiesResponse> getAll();
	public GetAllTechnologiesResponse getById(int id);
	void add(CreateTechnologyRequest createRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
}