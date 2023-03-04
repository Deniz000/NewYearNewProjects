package kodlama.io.rentACar.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Repository  // "dataAccess nesnesidir" demek
public class InMemoryBrandRepository implements BrandRepository {
	
	List<Brand> brands;
	

	public InMemoryBrandRepository() {
		brands = new ArrayList<>();
		brands.add(new Brand(1, "Bmw"));
		brands.add(new Brand(1, "Audi"));
		brands.add(new Brand(1, "Mercedes"));
		brands.add(new Brand(1, "Fiat"));
		brands.add(new Brand(1, "Renault "));
	}


	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
