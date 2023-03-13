package Kodlama.io.Devs.findADev.business.requests;

import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
	private int id;
	private String name;
	private ProgrammingLanguage language;
	//sadece p.dilini de güncelleyebilir
	

}
