package kodlama.io.rentACar;

import java.net.BindException;
import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	
	//aynı zamanda loglayabiliriz
	@ExceptionHandler  //hata oluşursa buradan geçecek //yakalanırsa da 
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)  //hata bilgisi döneceğim
	public ProblemDetails handleBusinessException(BusinessException businesExpection) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businesExpection.getMessage());
		return problemDetails;
	}
	
	@ExceptionHandler  //hata oluşursa buradan geçecek //yakalanırsa da 
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)  //hata bilgisi döneceğim
	public ProblemDetails handleValidationException(BindException bindException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage(bindException.getMessage());
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		
		return validationProblemDetails;
	}
	
	@Bean //bir tane modelmapper 'a ihtiyacım var bunu new le, kutuya ekle
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

//Brand --> Marka
//Car --> Araba 
