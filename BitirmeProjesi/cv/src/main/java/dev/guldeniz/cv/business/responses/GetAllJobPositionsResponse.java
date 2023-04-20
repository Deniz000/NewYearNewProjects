package dev.guldeniz.cv.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobPositionsResponse {
	
		private Long id;
	    private String positionName;
	    private String description;
	    
}
