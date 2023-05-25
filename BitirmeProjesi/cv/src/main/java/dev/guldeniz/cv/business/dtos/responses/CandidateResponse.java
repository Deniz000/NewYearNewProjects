package dev.guldeniz.cv.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse {

	private int id;
	private int jobSeekerId;
	private String coverLetter;
	private String githubLink;
	private String linkedInLink;
	private String schoolName;
}
