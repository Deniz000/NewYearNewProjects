package dev.guldeniz.cv.webApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.ExperienceService;
import dev.guldeniz.cv.business.requests.CreateExperienceRequest;
import dev.guldeniz.cv.core.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/experience")
@AllArgsConstructor
public class ExperienceController {
	private ExperienceService experienceService;
	
	@GetMapping
	public Result add(CreateExperienceRequest experienceRequest) {
		return this.experienceService.add(experienceRequest);
	}
}
