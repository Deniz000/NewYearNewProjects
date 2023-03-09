package Kodlama.io.Devs.findADev.business.responses;

import java.util.List;

import Kodlama.io.Devs.findADev.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguagesResponse {
	private int id;
	private String languageName;
	private List<Technology> technologies;
	
}
