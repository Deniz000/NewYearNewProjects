package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor // 2. Ioc 'den kullansın
@Service  // 3. enjekte ederek kullanacağım, newlemeyeceğim
// o zaman Ioc 'ye yerleşsin
public class BrandBusinessRules {
	// 1. repository kullandı, bağımlılık var O halde
	private BrandRepository brandRepository;
	
	//iş kuralını yaz, uymadığı anda patlat 
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByBrandName(name)) {
			//problemi yakaladıın anda
			throw new BusinessException("Brand already exists");
			//
		}
	}
}
