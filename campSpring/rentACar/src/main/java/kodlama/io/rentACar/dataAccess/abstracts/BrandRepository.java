package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import kodlama.io.rentACar.entities.concretes.Brand;

//Dao ile aynı
//Markaları listeleyeceğiz. Bir sürü markayı listeliyo
//olacağız. Bu nedenle Array bazlı çalışmam gerekiyor. 

public interface BrandRepository {
	List<Brand> getAll();
	


}
 