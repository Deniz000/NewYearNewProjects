package kodlama.io.rentACar.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.core.entities.User;

public interface UserDto extends JpaRepository<User,Integer>{

	User findByEmail(String email);
}
