package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.CandidateService;
import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.business.dtos.responses.CandidateResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {
	
	private CandidateService candidateService;
	
	@PostMapping 
	public ResponseEntity<Result> add(@Valid CreateCandidateRequest candidateRequest) {
		Result result =  this.candidateService.add(candidateRequest);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<DataResult<List<CandidateResponse>>> getAll(){
		DataResult<List<CandidateResponse>> responses = this.candidateService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
// şunların farkını anlamadım
//	@GetMapping
//	public DataResult<List<CandidateResponse>> getAll(){
//		return this.candidateService.getAll();
//		
//	}
	

}
