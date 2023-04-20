package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.EmployerService;
import dev.guldeniz.cv.business.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.responses.GetAllEmployerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
public class EmployerController {
	
	private EmployerService employerService;
	
	@PostMapping("/register")
	public void add(@Valid CreateEmployerRequest employerReqest) throws Exception {
		if(!employerReqest.getPassword().equals(employerReqest.getConfirmPassword())) {
			throw new RuntimeException("Şifreler uyuşmuyor!");
		}
		this.employerService.add(employerReqest);
	}
	
	@GetMapping()
	public List<GetAllEmployerResponse> getAll(){
		return this.employerService.getAll();
	}
}
