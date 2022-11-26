package pl.com.chrzanowski.scma.service;

import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.User;

import java.util.Optional;


public interface UserService {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    void save(User user);
}
