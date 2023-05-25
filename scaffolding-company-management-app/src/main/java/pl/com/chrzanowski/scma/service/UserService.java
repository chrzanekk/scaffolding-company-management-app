package pl.com.chrzanowski.scma.service;


import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    User saveUser(UserDTO userDTO);

    void addRoleToUser(String email, ERole roleName);

    User getUser(String email);

    List<User> findAll();

    Boolean isUserExists(String userName);

    Boolean isEmailExists(String email);
}
