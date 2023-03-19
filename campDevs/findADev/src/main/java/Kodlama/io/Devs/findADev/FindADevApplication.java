package Kodlama.io.Devs.findADev;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FindADevApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindADevApplication.class, args);
	}

	
	@Bean //bir tane modelmapper 'a ihtiyacım var bunu new le, kutuya ekle
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
