package dev.guldeniz.cv.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobSeekeerRequest {
	

	@NotNull
	@NotBlank
	private String firstName;

	@NotNull
	@NotBlank
	private String lastName;
	
	@NotNull
	@NotBlank
	private String nationalIdentity;

	@NotNull(message = "Birth year cannot be null")
	private int birthYear;

	@NotNull
	@NotBlank
	private String eMail;

	@NotNull
	@NotBlank 
	private String password;

	@NotNull
	@NotBlank
	private String confirmPassword;
	
}
