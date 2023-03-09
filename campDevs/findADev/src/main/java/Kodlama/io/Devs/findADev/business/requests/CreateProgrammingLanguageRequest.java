package Kodlama.io.Devs.findADev.business.requests;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageRequest {
	private String languageName;
	private Set<String> techNames;	
}