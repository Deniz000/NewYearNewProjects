package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service  //business nesnesi demek
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	

	//Burada da BrandReppo 'yu implemente edeni new'liyor
	//yeni spring versiyonlarında yazmasak da bu şekilde çalışır. 
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}


	@Override
	public List<Brand> getAll() {
		//iş kkuralları
		return brandRepository.getAll();
	}
}
