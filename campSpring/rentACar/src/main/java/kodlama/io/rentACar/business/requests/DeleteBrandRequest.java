package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBrandRequest {
	//Elimde şöyle bi marka var bunu kaydeder misin?
	//Api 'yi kullanan son kullanıcıdan istek alıyorum request
	private int id;
	private String name;
	
}
