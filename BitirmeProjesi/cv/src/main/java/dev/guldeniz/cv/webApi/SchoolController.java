package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.SchoolService;
import dev.guldeniz.cv.business.dtos.requests.CreateSchoolRequest;
import dev.guldeniz.cv.business.dtos.responses.SchoolResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class SchoolController {
	private SchoolService schoolService;
	
	@PostMapping
	public ResponseEntity<Result> add(@Valid CreateSchoolRequest schoolRequest) {
		Result result =  this.schoolService.add(schoolRequest);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<DataResult<List<SchoolResponse>>> getAll(){
		DataResult<List<SchoolResponse>> responses = this.schoolService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
}
