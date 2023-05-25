package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Result> add(@Valid CreateEmployerRequest employerReqest) throws Exception {
		if (!employerReqest.getPassword().equals(employerReqest.getConfirmPassword())) {
			throw new RuntimeException("Şifreler uyuşmuyor!");
		}
		this.employerService.add(employerReqest);
		Result result = new SuccessResult("Kayıt işlemi başarılı!");
		return ResponseEntity.ok(result);
	}

	@GetMapping()
	public ResponseEntity<DataResult<List<EmployerResponse>>> getAll() {
		DataResult<List<EmployerResponse>> employers = this.employerService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(employers);
	}
}
