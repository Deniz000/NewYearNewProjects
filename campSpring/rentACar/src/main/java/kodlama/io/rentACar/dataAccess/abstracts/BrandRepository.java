package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

//Dao ile aynı
//Markaları listeleyeceğiz. Bir sürü markayı listeliyo
//olacağız. Bu nedenle Array bazlı çalışmam gerekiyor. 

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	//JPA İLE bütün fonksiyonlar neredeyse hazır. 
	//CONCRETE 'ı yok. Bellekte implemente etmiş gibi
	//bir class oluşturuyor. Ekstra gerekmiyor. 
	
	//halihazırda okmayan bir metot ekledik
	//concrete 'i silmiştik ne olacak şimdi
	// jpa bizim için keyword oluşturuyor
	//ve bu metodu kendininmiş gibi işliyor. 
	// exists 'i görüp bakıyor 
	//bu kullanımın fin seçenekleri de var
	// SPRİNG JPA KEYWORDS  
	boolean existsByName(String name);
	//find 'lı bişe kullanırsak  Brand find şeklinde 
	// çoklu istiyosak da List<>
}
 