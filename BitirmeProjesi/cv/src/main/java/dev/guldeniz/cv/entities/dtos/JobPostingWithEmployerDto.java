package dev.guldeniz.cv.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingWithEmployerDto {
	private Long id;
	private String companyName; 
	private String positionName;
	
}
