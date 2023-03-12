package Kodlama.io.Devs.findADev.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.findADev.business.abstracts.TechnologyService;
import Kodlama.io.Devs.findADev.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.findADev.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.findADev.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyRepository technologyRepository; 
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		super();
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<GetAllTechnologiesResponse> technologies = new ArrayList<GetAllTechnologiesResponse>();
		for(Technology technology : technologyRepository.findAll()) {
			GetAllTechnologiesResponse tech = new GetAllTechnologiesResponse();
			tech.setId(technology.getId());
			tech.setName(technology.getName());
			//tech.setLanguage(technology.getProgrammingLanguage().getName());
			technologies.add(tech);
		}
		return technologies ;
	}

	@Override
	public GetAllTechnologiesResponse getById(int id) {
		GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
		for(Technology technology : technologyRepository.findAll()) {
			if(technology.getId() == id) {
				response.setId(id);
				response.setName(technology.getName());
				response.setLanguage(technology.getProgrammingLanguage().toString());
			}
		}
		return response;
	}

	@Override
	public void add(CreateTechnologyRequest createRequest) throws Exception {
		if (!technologyRepository.findAll().isEmpty()) {
			for (Technology technology : technologyRepository.findAll()) {
				if (technology.getName().equals(createRequest.getName().toLowerCase())) {
					throw new Exception("Bu programlama dili eklenemez. Sistemde zaten mevcut!");
				}
			}
		}
		Technology technology = new Technology();
		technology.setName(createRequest.getName());
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteRequest) throws Exception {
		if (!technologyRepository.findAll().isEmpty()) {
			System.out.print("1111111111111");
			for (Technology technology : technologyRepository.findAll()) {
				System.out.print("22222222222222222");
				if (technology.getName().equals(deleteRequest.getName())) {
					technologyRepository.delete(technology);
					System.out.print("333333333333333333" + technology.getName());

				}
			}
		}
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
