package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
