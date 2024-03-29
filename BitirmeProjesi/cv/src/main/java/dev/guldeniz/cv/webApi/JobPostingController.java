package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.job.JobPostingService;
import dev.guldeniz.cv.business.dtos.requests.CreateJobPostingRequest;
import dev.guldeniz.cv.business.dtos.responses.JobPostingFilterResponse;
import dev.guldeniz.cv.business.dtos.responses.JobPostingResponse;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobpostings")
@AllArgsConstructor
public class JobPostingController {
	
	private JobPostingService jobPostingService;


	@GetMapping()
	public ResponseEntity<DataResult<List<JobPostingResponse>>> getAll(){
		DataResult<List<JobPostingResponse>> response = this.jobPostingService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	public ResponseEntity<Result> add(@Valid CreateJobPostingRequest jobPostingRequest) {
		Result result = this.jobPostingService.add(jobPostingRequest);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/deactivate")
	public Result deactivateJobPostingById(int jobPostingId) {
		return this.jobPostingService.deactivateJobPostingById(jobPostingId);
	}

	@GetMapping("/isActive")
    public DataResult<List<JobPostingFilterResponse>> getAllActiveJobPostings(){
		return this.jobPostingService.findAllByIsActiveTrue();
    }

	@GetMapping("/isActiveByDesc")
    public DataResult<List<JobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateDesc(){
		return this.jobPostingService.findAllByIsActiveTrueOrderByPublishDateDesc();
    } 
	
	@GetMapping("/isActiveByAsc")
    public DataResult<List<JobPostingFilterResponse>> findAllByIsActiveTrueOrderByPublishDateAsc(){
		return this.jobPostingService.findAllByIsActiveTrueOrderByPublishDateAsc();
    }
	@GetMapping("/selectedCompany")
    DataResult<List<JobPostingFilterResponse>> findAllByIsActiveAndCompanyName(String companyName){
		return this.jobPostingService.findAllByIsActiveAndCompanyName(companyName);
	}
	@GetMapping("/getJ")
	DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail(){
		System.out.print("3");
		return this.jobPostingService.getJobPostingWithEmployerDetail();
	}


}
