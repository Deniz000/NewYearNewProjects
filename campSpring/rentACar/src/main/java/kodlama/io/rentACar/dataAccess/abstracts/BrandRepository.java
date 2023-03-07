package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

//Dao ile aynı
//Markaları listeleyeceğiz. Bir sürü markayı listeliyo
//olacağız. Bu nedenle Array bazlı çalışmam gerekiyor. 

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	

}
 