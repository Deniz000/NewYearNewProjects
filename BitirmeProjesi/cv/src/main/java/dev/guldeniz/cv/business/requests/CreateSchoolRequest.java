package dev.guldeniz.cv.business.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolRequest {

	private int jobSeekerId;

	private String schoolName;

	private String department;

	private LocalDate startDay;

	private LocalDate endDay;

	private float gradeAvarage;

	private String description;

	private String type;

	private String adress;
}
