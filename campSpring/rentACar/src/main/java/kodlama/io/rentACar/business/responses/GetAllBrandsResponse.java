package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
//yani tüm brand leri listelemek istediğimizdeki yanıtımız
	
	private int id;
	private String brandName;
	
}

//brand --> id, name, quantity
//GetAllBransResponse --> id, name 

//tüm id leri alıp buradaki id ye
//name leri alıp buradaki name e atıyoruz. 
//Buna da MAPPİNG DENİYOR.