package dev.guldeniz.cv.webApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.jobSeeker.SchoolService;
import dev.guldeniz.cv.business.dtos.requests.CreateSchoolRequest;
import dev.guldeniz.cv.core.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class SchoolController {
	private SchoolService schoolService;
	
	@GetMapping
	public Result add(CreateSchoolRequest schoolRequest) {
		return this.schoolService.add(schoolRequest);
	}
}
