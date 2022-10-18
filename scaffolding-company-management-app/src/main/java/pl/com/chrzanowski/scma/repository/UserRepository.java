package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.com.chrzanowski.scma.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

   User findByLogin(String login);
}
