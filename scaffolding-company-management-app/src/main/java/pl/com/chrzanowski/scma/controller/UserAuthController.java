package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.payload.request.LoginRequest;
import pl.com.chrzanowski.scma.payload.request.RegisterRequest;
import pl.com.chrzanowski.scma.payload.response.JwtResponse;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.security.jwt.JwtUtils;
import pl.com.chrzanowski.scma.security.service.UserDetailsImpl;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.RoleDTO;
import pl.com.chrzanowski.scma.service.dto.UserDTO;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/auth")
public class UserAuthController {
    private final Logger log = LoggerFactory.getLogger(UserAuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;


    public UserAuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
                              UserService userService,
                              RoleService roleService,
                              PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        log.debug("REST request to login user {}", loginRequest);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
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

        if (stringRoles == null || stringRoles.isEmpty()) {
            roleDTOSet.add(roleService.findByName(ERole.ROLE_USER));
        } else {
            stringRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        RoleDTO adminRole = roleService.findByName(ERole.ROLE_ADMIN);
                        roleDTOSet.add(adminRole);
                    }
                    case "mod" -> {
                        RoleDTO modeRole = roleService.findByName(ERole.ROLE_MODERATOR);
                        roleDTOSet.add(modeRole);
                    }
                    default -> {
                        RoleDTO userRole = roleService.findByName(ERole.ROLE_USER);
                        roleDTOSet.add(userRole);
                    }
                }
            });
        }
        UserDTO newUser = UserDTO.builder().username(registerRequest.getUsername()).email(registerRequest.getEmail())
                .roles(roleDTOSet).enabled(true).locked(false).password(encoder.encode(registerRequest.getPassword()))
                .build();
        userService.save(newUser);

        return ResponseEntity.ok(new MessageResponse("Registered successfully!"));
    }

}
