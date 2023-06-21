package dev.guldeniz.cv.business.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingResponse {
	private String jobDescription;
	private String city;
	private int minSalary;
	private int maxSalary;
	private int openPositionCount;
    private LocalDate publishDate;
	private LocalDate applicationDeadline;
	private boolean active;
	private String positionName;
	private String companyName;

	
}
