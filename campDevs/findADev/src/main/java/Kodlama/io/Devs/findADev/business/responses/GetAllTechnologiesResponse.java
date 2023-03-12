package Kodlama.io.Devs.findADev.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechnologiesResponse {
	private int id;
	private String name;
	private String language;
}