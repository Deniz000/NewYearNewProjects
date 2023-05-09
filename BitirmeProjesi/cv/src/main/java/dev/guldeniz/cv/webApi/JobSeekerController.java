package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.JobSeekerService;
import dev.guldeniz.cv.business.dtos.JobSeekerDto;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
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
	public DataResult<List<JobSeekerDto>> getAll(){
		return this.jobSeekerService.getAll();
	}

	@PostMapping("/register")
	public Result add(@Valid CreateJobSeekeerRequest jobSeekerRequest) throws Exception {
		if(!jobSeekerRequest.getPassword().equals(jobSeekerRequest.getConfirmPassword())) {
			throw new RuntimeException("Şifreler Uyuşmuyor!");
		}
		
		return this.jobSeekerService.add(jobSeekerRequest);
	}
}
