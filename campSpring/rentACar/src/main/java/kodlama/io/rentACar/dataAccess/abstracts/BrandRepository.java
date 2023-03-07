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
}
 