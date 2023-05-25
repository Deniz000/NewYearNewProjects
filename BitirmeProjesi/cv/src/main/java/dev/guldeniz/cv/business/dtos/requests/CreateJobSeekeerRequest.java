package dev.guldeniz.cv.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@Size(min=3)
	private String firstName;

	@NotNull
	@NotBlank
	@Size(min=2)
	private String lastName;
	
	@NotNull
	@NotBlank
	@Size(min=11, max=11)
	private String nationalIdentity;

	@NotNull
	private int birthYear;

	@NotNull
	@NotBlank
	@Email(message="Geçersiz mail adresi")
	private String eMail;

	@NotNull
	@NotBlank 
	@Size(min=6)
	private String password;

	@NotNull
	@NotBlank
	@Size(min=6)
	private String confirmPassword;
	
}
