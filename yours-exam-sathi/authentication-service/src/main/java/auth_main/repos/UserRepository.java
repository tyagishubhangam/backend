package auth_main.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth_main.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);
	boolean existsByUserName(String userName);
	User findByUserName(String userName);
	User findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName, String email);


}


