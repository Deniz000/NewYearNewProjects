package kodlama.io.rentACar.business.abstracts;


import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	
	java.util.List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void delete(int id);
	void update(UpdateBrandRequest updateBrandRequest);
	
}
