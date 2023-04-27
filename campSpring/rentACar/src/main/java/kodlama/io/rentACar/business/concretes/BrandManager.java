package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service  //business nesnesi demek
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	

	//Burada da BrandReppo 'yu implemente edeni new'liyor
	//yeni spring versiyonlarında yazmasak da bu şekilde çalışır. 
	//mimarilerde ENTİTY NEW LEMENİN BİR SORUNU YOKTUR.

//1.18 de kaldımm
	
	@Override
	public DataResult<List<GetAllBrandsResponse>> getAll() {
		List<Brand> brands = brandRepository.findAll();
		//Bizim tüm brand 'lerimizi al 
		//strea ile tarayıp her bir brand nesnesini maple GetAllBrand ' e çevir yani maskele ve içteki tüm malzelemer görünmesin
		//senin verdiklerini bilsinler sadece 
		//join atıp joinli halini verir.
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		//iş kkuralları
		System.out.print(brands);
		return new SuccessDataResult<List<GetAllBrandsResponse>>
		(brandsResponse, "Data Listelendi!");
		
	}


	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getBrandName());;
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		System.out.print(brand.getBrandName() + "-------------------------------");
		this.brandRepository.save(brand);	
		return new SuccessResult("Ürün eklendi");
	}


 
	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult("Ürün silindi!");
	}


	@Override
	public DataResult<GetByIdBrandResponse> getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return new SuccessDataResult<GetByIdBrandResponse>(response,"Data Listelendi!");
	}


	@Override
	public Result delete(int id) {
		this.brandRepository.deleteById(id);
		return new SuccessResult("Ürün güncellendi!");
		
	}

//
//	@Override
//	public DataResult<Brand> getByBrandName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public DataResult<Brand> getByBrandNameAndModelId(String brandnameName, int modelId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public DataResult<List<Brand>> getByBrandNameOrModelID(String name, int modelId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public DataResult<List<Brand>> getByModelIdIn(List<Integer> models) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public DataResult<List<Brand>> GetByNameAndCategory(String name, int modelId) {
//		// TODO Auto-generated method stub
//		return null;
//	}  
}
