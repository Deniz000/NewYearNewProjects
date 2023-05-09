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
	//bu kullanımın find seçenekleri de var
	// SPRİNG JPA KEYWORDS  - https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
//	boolean existsByBrandName(String brandName);
//	
////	//find 'lı bişe kullanırsak  Brand find şeklinde 
////	// çoklu istiyosak da List<>
//	Brand getByBrandName(String brandName);
////
////	// select sorgusundaki and işlemi 
//	Brand getByBrandNameAndModels(String brandName, int modelId);
//////	
////	List<Brand> getByBrandNameOrModelID(String name, int modelId);
////
//////	// select * from model in(3,4,5) deki In
//	List<Brand> getByModelsIn(List<Integer> models);
//////	
////	//jpql yazımı  
////	// :değişken gelen değerdir - parametre 
//	//kendimiz bir sorgu yazacağımız zaman büyük harfle yazarız aşağıdaki gibi olur 
//	@Query("From Brand where name=:brandName and model_id=:models")
//	List<Brand> GetByBrandNameAndModels(String brandName, int models);
//	//select * from brand where name=bişey and categoryId= bişey	
}