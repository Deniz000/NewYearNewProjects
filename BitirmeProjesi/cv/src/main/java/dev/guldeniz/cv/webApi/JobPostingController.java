package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.JobPostingService;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.responses.GetAllJobPostingResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobpostings")
@AllArgsConstructor
public class JobPostingController {
	private JobPostingService jobPostingService;


	@GetMapping()
	public DataResult<List<GetAllJobPostingResponse>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@PostMapping()
	public Result add(@Valid CreateJobPostingRequest jobPostingRequest) {
		return this.jobPostingService.add(jobPostingRequest);
	}

}
