package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.JobSeekerService;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobseeker")
@AllArgsConstructor
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;
	
	@GetMapping()
	public List<GetAllJobSeekerResponse> getAll(){
		return this.jobSeekerService.getAll();
	}

	@PostMapping()
	public void add(@Valid CreateJobSeekeerRequest jobSeekerRequest) throws Exception {
		this.jobSeekerService.add(jobSeekerRequest);
	}
}
