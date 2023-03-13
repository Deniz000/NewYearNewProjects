package Kodlama.io.Devs.findADev.business.requests;

import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTechnologyRequest {
	private String name;
	//sadece p.dilini de silebilir
	private ProgrammingLanguage language;


}
