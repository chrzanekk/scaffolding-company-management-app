package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.chrzanowski.scma.controller.util.PaginationUtil;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.exception.BadRequestAlertException;
import pl.com.chrzanowski.scma.exception.RoleException;
import pl.com.chrzanowski.scma.payload.request.RegisterRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.RoleDTO;
import pl.com.chrzanowski.scma.service.dto.UserDTO;
import pl.com.chrzanowski.scma.service.filter.user.UserFilter;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private static final String ENTITY_NAME = "userController";
    private final UserService userService;

    private final PasswordEncoder encoder;
    private final RoleService roleService;

    public UserController(UserService userService, PasswordEncoder encoder, RoleService roleService) {
        this.userService = userService;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.debug("REST request to register new user {}", registerRequest);
        if (Boolean.TRUE.equals(userService.isUserExists(registerRequest.getUsername()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Username is already taken!"));
        }

        if (Boolean.TRUE.equals(userService.isEmailExists(registerRequest.getEmail()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error. Email is already in use!"));
        }

        Set<String> stringRoles = registerRequest.getRole();
        Set<RoleDTO> roleDTOSet = new HashSet<>();

        if (stringRoles == null) {
            roleDTOSet.add(roleService.findByName(ERole.ROLE_USER));
        } else {
            stringRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        try {
                            RoleDTO adminRole = roleService.findByName(ERole.ROLE_ADMIN);
                            roleDTOSet.add(adminRole);
                        } catch (RoleException e) {
                            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Role not found");
                        }
                    }
                    case "mod" -> {
                        try {
                            RoleDTO modeRole = roleService.findByName(ERole.ROLE_MODERATOR);
                            roleDTOSet.add(modeRole);
                        } catch (RoleException e) {
                            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Role not found");
                        }
                    }
                    default -> {
                        RoleDTO userRole = roleService.findByName(ERole.ROLE_USER);
                        roleDTOSet.add(userRole);
                    }
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
    //todo implement update user - should connect with confir registration, password reset etc? need to find out

    @GetMapping(path = "/")
    public ResponseEntity<List<UserDTO>> getUsersByFilter(UserFilter userFilter) {
        log.debug("REST request to get all users by filter: {}", userFilter);
        List<UserDTO> result = userService.findByFilter(userFilter);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(path = "/page")
    public ResponseEntity<List<UserDTO>> getUsersByFilterAndPage(UserFilter userFilter, Pageable pageable) {
        log.debug("REST request to get all users by filter and page: {},{}", userFilter, pageable);
        Page<UserDTO> result = userService.findByFilterAndPage(userFilter, pageable);
        HttpHeaders headers =
                PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequestUri(),
                        result);
        return ResponseEntity.ok().headers(headers).body(result.getContent());
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        log.debug("REST request to get user by id: {}", id);
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        log.debug("REST request to delete user by id: {}", id);
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
