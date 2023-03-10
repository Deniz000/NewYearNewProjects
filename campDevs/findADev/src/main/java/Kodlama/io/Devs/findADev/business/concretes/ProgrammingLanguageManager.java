package Kodlama.io.Devs.findADev.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.findADev.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.findADev.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	ProgrammingLanguageRepository pLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository pLanguageRepository) {
		super();
		this.pLanguageRepository = pLanguageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {

		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		for (ProgrammingLanguage language : pLanguageRepository.findAll()) {
			GetAllLanguagesResponse pl = new GetAllLanguagesResponse();
			pl.setId(language.getId());
			pl.setName(language.getName());
			pl.setTechnologies(language.getTechnologies());
			languagesResponse.add(pl);
		}
		return languagesResponse;
	}

	@Override
	public GetAllLanguagesResponse getById(int id) {
		GetAllLanguagesResponse languageRequest = new GetAllLanguagesResponse();
		for(ProgrammingLanguage language : pLanguageRepository.findAll()) {
			if(language.getId() == id) {
				languageRequest.setId(language.getId());
				languageRequest.setName(language.getName());
				languageRequest.setTechnologies(language.getTechnologies());
				return languageRequest;
			}
		}
		return null;
	}

	@Override
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if (!pLanguageRepository.findAll().isEmpty()) {
			for (ProgrammingLanguage planguage : pLanguageRepository.findAll()) {
				if (planguage.getName().equals(createProgrammingLanguageRequest.getName().toLowerCase())) {
					throw new Exception("Bu programlama dili sistemde zaten mevcut!");
				}
			}
		}
		ProgrammingLanguage newLanguage = new ProgrammingLanguage();
		newLanguage.setName(createProgrammingLanguageRequest.getName().toLowerCase());

		pLanguageRepository.save(newLanguage);
	}


	@Override
	public void delete(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		for(ProgrammingLanguage language : pLanguageRepository.findAll()) {
			if(language.getId() == createProgrammingLanguageRequest.getId()) {
				pLanguageRepository.deleteById(createProgrammingLanguageRequest.getId());
			}
		}
		
	}

	@Override
	public void update(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
