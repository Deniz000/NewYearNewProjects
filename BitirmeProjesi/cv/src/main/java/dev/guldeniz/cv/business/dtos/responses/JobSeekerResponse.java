package dev.guldeniz.cv.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private int birthYear;
	private String ePosta;
}
