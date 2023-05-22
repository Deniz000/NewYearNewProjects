package dev.guldeniz.cv.business.dtos.requests;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageRequest {	
	private int id;
	private String languageName;
	private Technology technology;

}
