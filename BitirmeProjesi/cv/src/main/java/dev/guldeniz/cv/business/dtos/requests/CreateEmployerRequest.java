package dev.guldeniz.cv.business.dtos.requests;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

	@NotNull
	@NotBlank
	@URL(message="Geçersiz web adresi")
	private String webAddress;

	@NotNull
	@NotBlank
	@Size(min=10,max=11)
    private String phone;
	//@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Geçersiz telefon numarası")

	@NotNull()
	@NotBlank
	@Email(message= "Geçersiz eposta adresi")
	private String eMail;

	@NotNull()
	@NotBlank
	@Size(min = 6, message = "Minimum 6 karakter girmelisiniz")
	private String password;
	
	@NotNull()
	@NotBlank
	@Size(min = 6, message = "Minimum 6 karakter girmelisiniz")
	private String confirmPassword;
	
}
