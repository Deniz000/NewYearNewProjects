package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.JobSeekerService;
import dev.guldeniz.cv.business.dtos.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.dtos.responses.JobSeekerResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobseekers")
@AllArgsConstructor
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;
	
	@GetMapping()
	public ResponseEntity<DataResult<List<JobSeekerResponse>>> getAll(){
		DataResult<List<JobSeekerResponse>> all =  this.jobSeekerService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}

	@PostMapping("/register")
	public ResponseEntity<Result> add(@Valid CreateJobSeekeerRequest jobSeekerRequest) throws Exception {
		if(!jobSeekerRequest.getPassword().equals(jobSeekerRequest.getConfirmPassword())) {
			throw new RuntimeException("Şifreler Uyuşmuyor!");
		}
		Result result = this.jobSeekerService.add(jobSeekerRequest);
		return ResponseEntity.ok(result);
	}
}
