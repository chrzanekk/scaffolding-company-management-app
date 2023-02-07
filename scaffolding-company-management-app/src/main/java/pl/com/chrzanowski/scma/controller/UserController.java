package pl.com.chrzanowski.scma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.service.dto.UserDTO;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userDTO));
    }

}
