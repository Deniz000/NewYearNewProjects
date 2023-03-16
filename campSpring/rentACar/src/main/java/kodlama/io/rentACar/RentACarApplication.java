package kodlama.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	
	@Bean //bir tane modelmapper 'a ihtiyacım var bunu new le, kutuya ekle
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

//Brand --> Marka
//Car --> Araba 
