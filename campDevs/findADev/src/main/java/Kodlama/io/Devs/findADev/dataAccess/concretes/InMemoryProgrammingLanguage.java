package Kodlama.io.Devs.findADev.dataAccess.concretes;

import java.util.List;

import Kodlama.io.Devs.findADev.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> listOfProgrammingLanguage;

	public InMemoryProgrammingLanguage() {
		listOfProgrammingLanguage.add(new ProgrammingLanguage(0,"Java"));
		listOfProgrammingLanguage.add(new ProgrammingLanguage(1,"C#"));
		listOfProgrammingLanguage.add(new ProgrammingLanguage(2,"Python"));
		listOfProgrammingLanguage.add(new ProgrammingLanguage(3,"Go"));
		listOfProgrammingLanguage.add(new ProgrammingLanguage(4,"Php"));		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return listOfProgrammingLanguage;
	}





	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language: listOfProgrammingLanguage) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}





	@Override
	public void add(ProgrammingLanguage language) {
		listOfProgrammingLanguage.add(language);
		System.out.println("Öğre Eklendi");
	}





	@Override
	public void delete(ProgrammingLanguage language) {
		listOfProgrammingLanguage.remove(language);
		System.out.println("Öğre Silindi");
	}





	@Override
	public void update(ProgrammingLanguage language) {
		//sonra yapılack
	}


}
