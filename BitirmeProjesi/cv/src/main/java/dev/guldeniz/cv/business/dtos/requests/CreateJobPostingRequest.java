package dev.guldeniz.cv.business.dtos.requests;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
public class CreateJobPostingRequest {

	@NotNull
	@Size(min=10)
	private String jobDescription;

	@NotNull
	private int cityId;

	@NotNull
	private int minSalary;
	
	@NotNull
	private int maxSalary;
	
	@NotNull
	private int openPositionCount;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Yayın tarihini boş bırakamazsınız")
    private LocalDate publishDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Deadline tarihini boş bırakamazsınız")
	private LocalDate applicationDeadline;
	
	@NotNull
	private boolean active;
	
	@NotNull(message="Pozisyon alanı boş bırakılmamalı!")
	private int jobPositionId; 
	
	@NotNull(message="Şirket alanı boş bırakılmamalı!")
	private int employerId;
//burada id'leri çözemedim. Null kaydoluyor :(
}