package Kodlama.io.Devs.findADev.business.concretes;

import java.util.List;

import Kodlama.io.Devs.findADev.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.findADev.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	ProgrammingLanguageRepository pLanguageRepository;
	

	public ProgrammingLanguageManager(ProgrammingLanguageRepository pLanguageRepository) {
		super();
		this.pLanguageRepository = pLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return pLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return pLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		for(ProgrammingLanguage ln : pLanguageRepository.getAll()) {
			if(ln.getLanguageName().equals(language.getLanguageName())) {
				throw new Exception("iki kere " + language.getLanguageName() + " eklenemez.");
			}
		}
		pLanguageRepository.add(language);
	}

	@Override
	public void delete(ProgrammingLanguage language) throws Exception {
		boolean isThere = false;
		for(ProgrammingLanguage ln : pLanguageRepository.getAll()) {
			if(ln.getId() == language.getId()) {
				pLanguageRepository.delete(language);
				isThere = true;
			}
		}
		if(isThere) {
			throw new Exception("Bu öğe zaten yok." + language.getLanguageName());
		}
		
	}

	@Override
	public void update(ProgrammingLanguage language) {
		// TODO Auto-generated method stub
		
	}
}
