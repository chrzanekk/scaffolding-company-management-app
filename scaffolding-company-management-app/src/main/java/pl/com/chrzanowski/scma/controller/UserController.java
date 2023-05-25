package pl.com.chrzanowski.scma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.payload.request.RegisterRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.RoleDTO;
import pl.com.chrzanowski.scma.service.dto.UserDTO;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private static final String ENTITY_NAME = "userController";
    private final UserService userService;

    private final PasswordEncoder encoder;
    private final RoleService roleService;

    public UserController(UserService userService, PasswordEncoder encoder, RoleService roleService) {
        this.userService = userService;
        this.encoder = encoder;
        this.roleService = roleService;
    }
// todo check ticket #1 on github
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if(userService.isUserExists(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Username is already taken!"));
        }

        if(userService.isEmailExists(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Email is already in use!"));
        }

        UserDTO newUser = UserDTO.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(encoder.encode(registerRequest.getPassword())).build();

        Set<String> stringRoles = registerRequest.getRole();
        Set<RoleDTO> roleDTOSet = new HashSet<>();

        if (stringRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new ObjectNotFoundException("Role not found"));
        }
    }




}
