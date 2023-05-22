package dev.guldeniz.cv.business.dtos.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExperienceRequest {

	private Long id;
	private int jobSeeker;
	private String companyName;
	private String jobPosition;
	private LocalDate startDay;
	private LocalDate endDay;
	private String description;
	private String city;
	private String workType;
	
}
