package dev.guldeniz.cv.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFilterDto {
	
	private String companyName;
	private String positionName;
	private int openPositionCount;
    private LocalDate publishDate;
	private LocalDate applicationDeadline;

}
