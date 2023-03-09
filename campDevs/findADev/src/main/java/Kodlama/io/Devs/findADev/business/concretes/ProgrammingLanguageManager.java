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
			pl.setLanguageName(language.getName());
			pl.setTechnologies(language.getTechnologies());
			languagesResponse.add(pl);
		}
		return languagesResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		// TODO Auto-generated method stub

	}

}
