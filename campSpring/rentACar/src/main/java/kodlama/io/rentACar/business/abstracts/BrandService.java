package kodlama.io.rentACar.business.abstracts;


import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface BrandService {
	
	DataResult<List<GetAllBrandsResponse>> getAll();
	DataResult<GetByIdBrandResponse> getById(int id);
	Result add(CreateBrandRequest createBrandRequest);
	Result delete(int id);
	Result update(UpdateBrandRequest updateBrandRequest);
//
//	DataResult<Brand> getByBrandName(String brandName);
//	
//	DataResult<Brand> getByBrandNameAndModelId(String brandName, int modelId);
//	
//	DataResult<List<Brand>> getByBrandNameOrModelID(String brandName, int modelId);
//	
//	DataResult<List<Brand>> getByModelIdIn(List<Integer> models);
//	
//	DataResult<List<Brand>> GetByNameAndCategory(String brandName, int modelId);
//	
}
