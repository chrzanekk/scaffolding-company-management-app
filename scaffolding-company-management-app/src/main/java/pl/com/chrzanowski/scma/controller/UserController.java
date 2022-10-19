package pl.com.chrzanowski.scma.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.domain.UserDto;
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
    public List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    void addUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

}
