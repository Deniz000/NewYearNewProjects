package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	//Elimde şöyle bi marka var bunu kaydeder misin?
	//Api 'yi kullanan son kullanıcıdan istek alıyorum request
	
	@NotNull //backend zorunlu, frontend opsiyonel
	@NotBlank
	private String brandName;
	
}
