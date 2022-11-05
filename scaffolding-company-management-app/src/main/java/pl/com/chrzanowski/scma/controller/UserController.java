package pl.com.chrzanowski.scma.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.domain.UserDTO;
import pl.com.chrzanowski.scma.model.User;
import pl.com.chrzanowski.scma.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }


}
