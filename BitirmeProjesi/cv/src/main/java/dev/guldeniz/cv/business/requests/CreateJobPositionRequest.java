package dev.guldeniz.cv.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobPositionRequest {
	private Long id;
	private String positionName;
	private String description;

}
