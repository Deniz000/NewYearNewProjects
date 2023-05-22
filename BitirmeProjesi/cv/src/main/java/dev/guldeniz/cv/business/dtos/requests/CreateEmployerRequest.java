package dev.guldeniz.cv.business.dtos.requests;

import jakarta.validation.constraints.Email;
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
	
	@NotNull()
	@NotBlank
	private String companyName;

	@NotNull()
	@NotBlank
	private String webAddress;

	@NotNull()
	@NotBlank
    private String phone;
	
	@NotNull()
	@NotBlank
	@Email
	private String eMail;

	@NotNull()
	@NotBlank
	private String password;
	
	@NotNull()
	@NotBlank
	private String confirmPassword;
	
}
