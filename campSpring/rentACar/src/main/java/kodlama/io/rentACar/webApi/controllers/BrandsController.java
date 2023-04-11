package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

//uygulama çalıştığı esnada, üstüne geliyo
//kimde restontroller var diye arıyo ve demek ki
//burası eriişim noktası oluyo
//-> @RequestMapping buraya nasıl ulaşsın demek 
//yani adresleme 

@RestController  //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandServidce;

	//1. parametrelere bak
	// uygulamayı tara brand service 'i kim implemente ediyor bak
	//3. aha brand manager. Onun new'lenmiş halini bana ver.

	
	@GetMapping()
	public DataResult<List<GetAllBrandsResponse>> getAll(){
		return brandServidce.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetByIdBrandResponse> getById(@PathVariable int id) {
		return brandServidce.getById(id);
	}
	 
	//mapping eşleme dedik. Bunlar gönderileni bizim entity miz ile eşler
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public Result add(@Valid() CreateBrandRequest createBrandRequest) {
		return this.brandServidce.add(createBrandRequest);
	}
	 
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandServidce.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody UpdateBrandRequest updateRequest) {
 		this.brandServidce.update(updateRequest);
	}
	
} 