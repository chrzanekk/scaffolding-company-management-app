package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.UserDto;
import pl.com.chrzanowski.scma.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(UserDto userDto);

    Optional<User> findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
