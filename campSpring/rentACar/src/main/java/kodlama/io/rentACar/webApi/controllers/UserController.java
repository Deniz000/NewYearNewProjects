package kodlama.io.rentACar.webApi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.results.ErrorDataResult;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid User user) {
//		return ResponseEntity.ok(this.userService.add(user));
		 return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
	} 

	//intersepter : burası aop ya, metodu sarmalıyoruz ya buna deniyor. 
	//exception olduğu zaman çalışacak kod. Sonra taşıyacağız
	// .class bunun tipini belirtiyoruz sadece
	//respond status : bad_request => 500 hatası deniyor buna 
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError error : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(error.getField(), error.getDefaultMessage());
		}
		System.out.println(validationErrors);
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları! Ben bu çıktıyı bekliyorum..");
		return errors;
	}
}

