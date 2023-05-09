package dev.guldeniz.cv.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {

	private int id;
	private String companyName;
	private String webAddress;
    private String phone;
	private String eMail;

}
