package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.job.JobPositionService;
import dev.guldeniz.cv.business.dtos.requests.CreateJobPositionRequest;
import dev.guldeniz.cv.business.dtos.responses.JobPositionsResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobpositions")
@AllArgsConstructor
public class JobPositionController {
	private JobPositionService jobPositionService;

	@GetMapping()
	public DataResult<List<JobPositionsResponse>> getAll(){
		return this.jobPositionService.getAll();
	}
	@PostMapping()
	public Result add(@Valid CreateJobPositionRequest positionRequest) {
		return this.jobPositionService.add(positionRequest);
	}
	
	@GetMapping("/getByPositionNameContains")
	DataResult<List<JobPosition>> getByPositionNameContains(String positionName){
		return this.jobPositionService.getByPositionNameContains(positionName);
	}
	
	@GetMapping("/pages")
	DataResult<List<JobPositionsResponse>> getAll(int pageNumber, int pageSize){
		return this.jobPositionService.getAll(pageNumber, pageSize);
	}
	
	@GetMapping("/sortedlist")
	DataResult<List<JobPositionsResponse>> getAllSorted(){
		return this.jobPositionService.getAllSorted();
	}

	
}
