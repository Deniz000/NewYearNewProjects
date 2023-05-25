package dev.guldeniz.cv.business.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolResponse {

	private int candidateId;
	private String schoolName;
	private String department;
	private LocalDate startDay;
	private LocalDate endDay;
	private float gradeAvarage;
	private String description;
	private String type;
	private String address;
}
