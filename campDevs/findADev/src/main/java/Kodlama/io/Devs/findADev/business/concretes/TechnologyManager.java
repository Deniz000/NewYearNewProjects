package Kodlama.io.Devs.findADev.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.findADev.business.abstracts.TechnologyService;
import Kodlama.io.Devs.findADev.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateTechnologyRequest;
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
			tech.setLanguage(technology.getProgrammingLanguage().getName().toString());
			technologies.add(tech);
		}
		return technologies ;
	}

	@Override
	public GetAllTechnologiesResponse getById(int id) {
		GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
		for(Technology technology : technologyRepository.findAll()) {
			if(technology.getId() == id) {
				response.setId(technology.getId());
				response.setName(technology.getName());
				response.setLanguage(technology.getProgrammingLanguage().toString());
				return response;
			}
		}
		return null;
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
		technology.getProgrammingLanguage().setName(createRequest.getLanguage().getName());
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteRequest) throws Exception {
		if (!technologyRepository.findAll().isEmpty()) {
			for (Technology technology : technologyRepository.findAll()) {
				if (technology.getName().equals(deleteRequest.getName())) {
					technologyRepository.delete(technology);

				}
			}
		}
	}

	@Override
	public void update(UpdateTechnologyRequest updateRequest) throws Exception {
		Technology technology = new Technology();
		technology.setName(updateRequest.getName());
		this.technologyRepository.save(technology);
	}

}
