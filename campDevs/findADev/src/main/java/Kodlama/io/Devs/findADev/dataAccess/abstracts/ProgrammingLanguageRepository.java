package Kodlama.io.Devs.findADev.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	//JPA İLE bütün fonksiyonlar neredeyse hazır. 
	//CONCRETE 'ı yok. Bellekte implemente etmiş gibi
	//bir class oluşturuyor. Ekstra gerekmiyor. 
}
