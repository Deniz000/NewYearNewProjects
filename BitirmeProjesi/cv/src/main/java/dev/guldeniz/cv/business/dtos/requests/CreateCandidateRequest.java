package dev.guldeniz.cv.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateRequest {
	
	@NotNull
	private int jobSeekerId;
	
	@NotNull
	@NotBlank
	@Size(min=50)
	private String coverLetter;
	

	@NotNull
	@NotBlank
    @Pattern(regexp = "(https?://)?(www\\.)?github\\.com/.+")
	private String githubLink;

	@NotNull
	@NotBlank
    @Pattern(regexp = "(https?://)?(www\\.)?linkedin\\.com/.+")
	private String linkedInLink;
	
	@NotNull
	@NotBlank
	private String schoolName;
}
