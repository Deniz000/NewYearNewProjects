package Kodlama.io.Devs.findADev.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageRequest {
	//Api'den gelen kısım buraası. Bu nokta apiden geleni class'a çevirdiğimiz nokta, biz de buna response cevaplar oluşturuyoruz.
	private int id;
	private String name;
}