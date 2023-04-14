package dev.guldeniz.cv.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployerRequest {
	
	@NotNull
	@NotBlank
	private String companyName;

	@NotNull
	@NotBlank
	private String webAddress;

	@NotNull
	@NotBlank
    private String phone;
	
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
