package tr.softtech.patika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.softtech.patika.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(Long phone_number);

    boolean existsByUsernameAndPhoneNumber(String username, Long phoneNumber);

    User getUserByUsername(String username);

    Optional<User> findByUsername(String username);

}
