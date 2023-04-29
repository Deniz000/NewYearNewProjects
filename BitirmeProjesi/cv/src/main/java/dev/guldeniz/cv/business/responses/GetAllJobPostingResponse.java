package dev.guldeniz.cv.business.responses;

import java.time.LocalDate;

import dev.guldeniz.cv.entities.concretes.Employer;
import dev.guldeniz.cv.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllJobPostingResponse {
	private String jobDescription;
	private String city;
	private int minSalary;
	private int maxSalary;
	private int openPositionCount;
	private LocalDate applicationDeadline;
	private boolean active;
	private JobPosition jobPosition;
	private Employer employer;
}
