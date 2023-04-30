package dev.guldeniz.cv.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobPostingFilterResponse {
	
	private String companyName;
	private String positionName;
	private int openPositionCount;
    private LocalDate publishDate;
	private LocalDate applicationDeadline;

}
