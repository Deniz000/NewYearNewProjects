package dev.guldeniz.cv.business.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceResponse {
	private int id;
	private int jobSeeker;
	private String companyName;
	private String jobPosition;
	private LocalDate startDay;
	private LocalDate endDay;
	private String description;
	private String city;
	private String workType;
}
