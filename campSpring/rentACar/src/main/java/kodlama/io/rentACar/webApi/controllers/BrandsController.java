package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;

//uygulama çalıştığı esnada, üstüne geliyo
//kimde restontroller var diye arıyo ve demek ki
//burası eriişim noktası oluyo
//-> @RequestMapping buraya nasıl ulaşsın demek 
//yani adresleme 

@RestController  //annotation
@RequestMapping("/api/brans")
public class BrandsController {
	private BrandService brandServidce;

	//1. parametrelere bak
	// uygulamayı tara brand service 'i kim implemente ediyor bak
	//3. aha brand manager. Onun new'lenmiş halini bana ver.
	
	@Autowired
	public BrandsController(BrandService brandServidce) {
		super();
		this.brandServidce = brandServidce;
	}
	
	@GetMapping("/getall")
	public List<Brand> getAll(){
		return brandServidce.getAll();
		
	}
}