package dev.guldeniz.cv.business.dtos.requests;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExperienceRequest {

	@NotNull
	private int jobSeeker;
	
	@NotNull
	private int employerId;

	@NotNull
	private int jobPositionId;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="İşe başlama tarihinizi boş bırakmayınız")
	private LocalDate startDay;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="İşten çıkma tarihinizi boş bırakmayınız")
	private LocalDate endDay;

	@NotNull
	@NotBlank(message="İş tanımınızı boş bırakmayınız")
	private String description;
	
	@NotNull
	private int city;

	@NotNull
	private int workType;
	
}
