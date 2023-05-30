package pl.com.chrzanowski.scma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.exception.BadRequestAlertException;
import pl.com.chrzanowski.scma.exception.RoleException;
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
        if (userService.isUserExists(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Username is already taken!"));
        }

        if (userService.isEmailExists(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Email is already in use!"));
        }

        Set<String> stringRoles = registerRequest.getRole();
        Set<RoleDTO> roleDTOSet = new HashSet<>();

        if (stringRoles == null) {
            RoleDTO userRole = roleService.findByName(ERole.ROLE_USER);
        } else {
            stringRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        try {
                            RoleDTO adminRole = roleService.findByName(ERole.ROLE_ADMIN);
                            roleDTOSet.add(adminRole);
                            break;
                        } catch (RoleException e) {
                            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Role not found");
                        }
                    case "mod":
                        try {
                            RoleDTO modeRole = roleService.findByName(ERole.ROLE_MODERATOR);
                            roleDTOSet.add(modeRole);
                            break;
                        } catch (RoleException e) {
                            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Role not found");
                        }
                    default:
                        RoleDTO userRole = roleService.findByName(ERole.ROLE_USER);
                        roleDTOSet.add(userRole);
                }
            });
        }
        UserDTO newUser = UserDTO.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .roles(roleDTOSet)
                .password(encoder.encode(registerRequest.getPassword())).build();
        userService.save(newUser);

        return ResponseEntity.ok(new MessageResponse("Registered successfully!"));
    }





}
