package pl.com.chrzanowski.scma.service;


import pl.com.chrzanowski.scma.model.UserDTO;

public interface UserService {

    String createUser(UserDTO user);

    public int enableUser(String email);
}
