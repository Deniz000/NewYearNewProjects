package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.employer.EmployerService;
import dev.guldeniz.cv.business.dtos.requests.CreateEmployerRequest;
import dev.guldeniz.cv.business.dtos.responses.EmployerResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
public class EmployerController {
	
	private EmployerService employerService;
	
	@PostMapping("/register")
	public Result add(@Valid CreateEmployerRequest employerReqest) throws Exception {
		if(!employerReqest.getPassword().equals(employerReqest.getConfirmPassword())) {
			throw new RuntimeException("Şifreler uyuşmuyor!");
		}
		this.employerService.add(employerReqest);
		return new SuccessResult("Kayıt işlemi başarılı!");
	}
	
	@GetMapping("/g")
	public DataResult<List<EmployerResponse>> getAll(){
		return this.employerService.getAll();
	}
}
