package pl.com.chrzanowski.scma.service;


import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.model.UserDTO;

import java.util.List;

public interface UserService {

    User saveUser(UserDTO userDTO);

    void addRoleToUser(String email, String roleName);

    User getUser(String email);

    List<User> findAll();
}
