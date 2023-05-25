package dev.guldeniz.cv.business.dtos.requests;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolRequest {

	@NotNull
	private int candidateId;

	@NotNull
	@NotBlank
	@Size(min=5)
	private String schoolName;

	@NotNull(message="lise için sayısal-sözel-eşit ağırlık yazınız")
	private String department;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Tarih alanı boş bırakılamaz!")
	private LocalDate startDay;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Tarih alanı boş bırakılamaz!")
	private LocalDate endDay;

	@NotNull(message="Lütfen ortalamanızı yazını!")
	private float gradeAvarage;
	
	private String description;

	@NotNull(message="Lütfen birini giriniz: \n UNDERGRADUATE, GRADUATE, POSTGRADUATE")
	private int type;

	@NotNull
	@NotBlank
	private String address;
}
