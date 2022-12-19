package pl.com.chrzanowski.scma.service;


import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.model.UserDTO;

import java.util.List;

public interface UserService {

    String createUser(UserDTO user);

    public int enableUser(String email);

    List<User> findAll();
}
