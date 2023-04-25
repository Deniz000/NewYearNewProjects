package dev.guldeniz.cv.business.requests;

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
public class CreateEmployerRequest {
	
	@NotNull(message = "company p")
	@NotBlank
	private String companyName;

	@NotNull(message = "web p")
	@NotBlank
	private String webAddress;

	@NotNull(message = "phone p")
	@NotBlank
    private String phone;
	
	@NotNull(message = "email p")
	@NotBlank
	private String eMail;

	@NotNull(message = "password")
	@NotBlank
	private String password;
	
	@NotNull(message = "confirm p")
	@NotBlank
	private String confirmPassword;
	
}
