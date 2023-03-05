package Kodlama.io.Devs.findADev.dataAccess.abstracts;

import java.util.*;

import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
		List<ProgrammingLanguage> getAll();
		public ProgrammingLanguage getById(int id);
		public void add(ProgrammingLanguage language);
		public void delete(ProgrammingLanguage language);
		public void update(ProgrammingLanguage language);
}
