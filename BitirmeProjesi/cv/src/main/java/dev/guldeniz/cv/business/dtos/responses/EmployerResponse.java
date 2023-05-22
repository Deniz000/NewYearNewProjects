package dev.guldeniz.cv.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResponse {

	private int id;
	private String companyName;
	private String webAddress;
    private String phone;
	private String eMail;

}
