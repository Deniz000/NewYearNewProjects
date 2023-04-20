package dev.guldeniz.cv.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobPositionRequest {
	private Long id;
	private String positionName;
	private String description;

}
