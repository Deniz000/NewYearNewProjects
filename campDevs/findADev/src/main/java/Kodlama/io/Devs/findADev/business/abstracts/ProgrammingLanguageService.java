package Kodlama.io.Devs.findADev.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	List<ProgrammingLanguage> getAll();
	public ProgrammingLanguage getById(int id);
	public void add(ProgrammingLanguage language) throws Exception; 
	public void delete(ProgrammingLanguage language) throws Exception; 
	public void update(ProgrammingLanguage language);
}
