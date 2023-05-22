package dev.guldeniz.cv.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateRequest {
	private int jobSeekerId;
	private String coverLetter;
	private String githubLink;
	private String linkedInLink;
	private String schoolName;
	private int id;
}
