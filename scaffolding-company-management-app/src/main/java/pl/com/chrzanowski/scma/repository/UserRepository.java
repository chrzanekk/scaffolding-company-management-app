package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.chrzanowski.scma.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmail(String email);
}
