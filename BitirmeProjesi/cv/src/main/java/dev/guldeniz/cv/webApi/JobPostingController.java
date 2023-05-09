package dev.guldeniz.cv.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.guldeniz.cv.business.abstracts.job.JobPostingService;
import dev.guldeniz.cv.business.dtos.JobPostingFilterDto;
import dev.guldeniz.cv.business.dtos.JobPostingDto;
import dev.guldeniz.cv.business.requests.CreateJobPostingRequest;
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
	public DataResult<List<JobPostingDto>> getAll(){
		return this.jobPostingService.getAll();
	}

	@PostMapping()
	public Result add(@Valid CreateJobPostingRequest jobPostingRequest) {
		return this.jobPostingService.add(jobPostingRequest);
	}
	
	@PutMapping("/deactivate")
	public Result deactivateJobPostingById(int jobPostingId) {
		return this.jobPostingService.deactivateJobPostingById(jobPostingId);
	}

	@GetMapping("/isActive")
    public DataResult<List<JobPostingFilterDto>> getAllActiveJobPostings(){
		return this.jobPostingService.findAllByIsActiveTrue();
    }

	@GetMapping("/isActiveByDesc")
    public DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateDesc(){
		return this.jobPostingService.findAllByIsActiveTrueOrderByPublishDateDesc();
    } 
	
	@GetMapping("/isActiveByAsc")
    public DataResult<List<JobPostingFilterDto>> findAllByIsActiveTrueOrderByPublishDateAsc(){
		return this.jobPostingService.findAllByIsActiveTrueOrderByPublishDateAsc();
    }
	@GetMapping("/selectedCompany")
    DataResult<List<JobPostingFilterDto>> findAllByIsActiveAndCompanyName(String companyName){
		return this.jobPostingService.findAllByIsActiveAndCompanyName(companyName);
	}
	@GetMapping("/getJ")
	DataResult<List<JobPostingWithEmployerDto>> getJobPostingWithEmployerDetail(){
		System.out.print("3");
		return this.jobPostingService.getJobPostingWithEmployerDetail();
	}


}
