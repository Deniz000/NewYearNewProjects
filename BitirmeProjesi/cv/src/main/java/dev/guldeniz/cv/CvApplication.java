package dev.guldeniz.cv;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
//	
//	@Bean
//	public CandidateService candaidateService() {
//		return new CandidateManager();
//	}
//
//	@Bean
//	public EmployerService employerService() {
//		return new EmployerManager();
//	}
//	@Bean
//	public JobSeekerService jobSeekerService() {
//		return new JobSeekerManager();
//	}
//
//	@Bean
//	public ExperienceService experienceService() {
//		return new ExperienceManager();
//	}
//	@Bean
//	public JobPositionService jobPositionService() {
//		return new JobPositionManager();
//	}
//
//	@Bean
//	public JobPostingService jobPostingService() {
//		return new JobPostingManager();
//	}
//
//	@Bean
//	public SchoolService schoolService() {
//		return new SchoolManager();
//	}

}
