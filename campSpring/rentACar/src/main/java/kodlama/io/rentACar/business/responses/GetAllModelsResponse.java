package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	private int id;
	private String name;
	private String brandName;
	/*Model mapper kullandığımız için buraya daha sonra 
	 gelip brandDescription ekleriz ve değiştirmemiz gereken bir  
	 yer kalmadan çalıştırabiliriz.*/
}
