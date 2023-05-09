package dev.guldeniz.cv.business.requests;

import java.time.LocalDate;

import dev.guldeniz.cv.entities.concretes.employer.Employer;
import dev.guldeniz.cv.entities.concretes.job.JobPosition;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobPostingRequest {

	@NotNull
	private String jobDescription;

	@NotNull
	private String city;

	@NotNull
	private int minSalary;
	
	@NotNull
	private int maxSalary;
	
	@NotNull
	private int openPositionCount;

	@NotNull
    private LocalDate publishDate;

	@NotNull
	private LocalDate applicationDeadline;
	
	@NotNull
	private boolean active;
	
	@NotNull
	private JobPosition jobPosition;
	
	@NotNull
	private Employer employer;

}