package dev.guldeniz.cv.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse {

	private int id;
	private String jobSeekerFirstName;
	private String jobSeekerLastName;
	private String coverLetter;
	private String githubLink;
	private String linkedInLink;
}
