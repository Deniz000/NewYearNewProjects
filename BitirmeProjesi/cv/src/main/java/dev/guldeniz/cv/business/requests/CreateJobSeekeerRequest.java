package dev.guldeniz.cv.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobSeekeerRequest {
	

	@NotNull
	@NotBlank
	private String ePosta;

	@NotNull
	@NotBlank
	private String passwordHash;
	
	@NotNull
	@NotBlank
	private boolean isActive;

	@NotNull
	@NotBlank
	private boolean isVerified;
	
	@NotNull
	@NotBlank
	private String firstName;

	@NotNull
	@NotBlank
	private String lastName;
	
	@NotNull
	@NotBlank
	private String nationalIdentity;

	@NotNull
	@NotBlank
	private int birthYear;

}
