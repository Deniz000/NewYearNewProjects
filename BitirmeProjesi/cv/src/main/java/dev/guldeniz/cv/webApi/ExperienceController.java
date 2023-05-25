package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.ExperienceService;
import dev.guldeniz.cv.business.dtos.requests.CreateExperienceRequest;
import dev.guldeniz.cv.business.dtos.responses.ExperienceResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/experience")
@AllArgsConstructor
public class ExperienceController {
	private ExperienceService experienceService;
	
	@PostMapping
	public ResponseEntity<Result> add(CreateExperienceRequest experienceRequest) {
		Result result =  this.experienceService.add(experienceRequest);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<DataResult<List<ExperienceResponse>>> getAll(){
		DataResult<List<ExperienceResponse>> responses = this.experienceService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
}
