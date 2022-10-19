package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.UserDto;
import pl.com.chrzanowski.scma.model.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByLogin(String login);

    List<UserDto> findAllUsers();
}
