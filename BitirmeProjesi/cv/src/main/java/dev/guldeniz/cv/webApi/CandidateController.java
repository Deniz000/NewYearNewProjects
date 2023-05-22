package dev.guldeniz.cv.webApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.CandidateService;
import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.core.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {
	
	private CandidateService candidateService;
	
	@GetMapping
	public Result add(CreateCandidateRequest candidateRequest) {
		return this.candidateService.add(candidateRequest);
	}

}
