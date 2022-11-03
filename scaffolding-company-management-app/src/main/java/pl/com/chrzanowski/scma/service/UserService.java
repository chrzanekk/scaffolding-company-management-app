package pl.com.chrzanowski.scma.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.com.chrzanowski.scma.domain.UserDto;
import pl.com.chrzanowski.scma.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
