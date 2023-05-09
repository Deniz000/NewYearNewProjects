package kodlama.io.rentACar.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.core.dataAccess.UserDto;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{

	private UserDto userDto;
	//private ModelMapperService modelMapperService;
	
	@Override
	public Result add(User user) {
		this.userDto.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDto.findByEmail(email), "Kullanıcı bulundu!");
	}

}
