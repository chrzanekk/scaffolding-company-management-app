package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.exception.EmailAlreadyExistsException;
import pl.com.chrzanowski.scma.exception.EmailNotFoundException;
import pl.com.chrzanowski.scma.exception.UsernameAlreadyExistsException;
import pl.com.chrzanowski.scma.payload.request.LoginRequest;
import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.request.RegisterRequest;
import pl.com.chrzanowski.scma.payload.response.JwtResponse;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.security.jwt.JwtUtils;
import pl.com.chrzanowski.scma.security.service.UserDetailsImpl;
import pl.com.chrzanowski.scma.service.ConfirmationTokenService;
import pl.com.chrzanowski.scma.service.PasswordResetTokenService;
import pl.com.chrzanowski.scma.service.SentEmailService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;
import pl.com.chrzanowski.scma.service.dto.PasswordResetTokenDTO;
import pl.com.chrzanowski.scma.service.dto.UserDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/auth")
public class UserAuthController {
    private final Logger log = LoggerFactory.getLogger(UserAuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;
    private final PasswordResetTokenService passwordResetTokenService;
    private final SentEmailService sentEmailService;


    public UserAuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
                              UserService userService,
                              ConfirmationTokenService confirmationTokenService,
                              PasswordResetTokenService passwordResetTokenService,
                              SentEmailService sentEmailService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
        this.confirmationTokenService = confirmationTokenService;
        this.passwordResetTokenService = passwordResetTokenService;
        this.sentEmailService = sentEmailService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        log.debug("REST request to login user {}", loginRequest);
        LoginRequest updatedRequest =
                LoginRequest.builder(loginRequest).username(loginRequest.getUsername().toLowerCase()).build();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(updatedRequest.getUsername(), updatedRequest.getPassword());
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
    @Transactional
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.debug("REST request to register new user {}", registerRequest);
        RegisterRequest updatedRequest =
                RegisterRequest.builder(registerRequest).username(registerRequest.getUsername().toLowerCase()).build();
        if (isUsernameTaken(updatedRequest.getUsername())) {
            throw new UsernameAlreadyExistsException("Error. Username is already in use.");
        }

        if (isEmailTaken(updatedRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Error. Email is already in use!");
        }

        UserDTO savedUser = userService.register(updatedRequest);
        String generatedToken = confirmationTokenService.generateToken();
        ConfirmationTokenDTO confirmationTokenDTO = confirmationTokenService.saveToken(generatedToken, savedUser);

        MessageResponse response = sentEmailService.sendAfterRegistration(confirmationTokenDTO, new Locale("pl"));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/confirm")
    public String confirmRegistration(@RequestParam("token") String token) {
        log.debug("REST request to confirm user registration. Token: {}", token);
        ConfirmationTokenDTO confirmationTokenDTO = confirmationTokenService.getConfirmationToken(token);
        sentEmailService.sendAfterEmailConfirmation(confirmationTokenDTO, new Locale("pl"));
        return userService.confirm(token);
    }

    @PutMapping("/request-password-reset")
    @Transactional
    public ResponseEntity<?> passwordReset(@Valid @NotNull @RequestBody PasswordResetRequest passwordResetRequest) {
        log.debug("REST request to set new password for user: {}", passwordResetRequest.getEmail());

        if (!isEmailTaken(passwordResetRequest.getEmail())) {
            throw new EmailNotFoundException("Email not found");
        }
        UserDTO userDTO = userService.getUser(passwordResetRequest.getEmail());
        String token = passwordResetTokenService.generate();
        PasswordResetTokenDTO passwordResetTokenDTO = passwordResetTokenService.save(token, userDTO);
        MessageResponse response = sentEmailService.sendPasswordResetMail(passwordResetTokenDTO, new Locale("pl"));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/reset-password")
    public String newPasswordPut(@RequestParam("token") String token,
                                 @RequestBody NewPasswordPutRequest request) {
        log.debug("REST request to set new password by token: {}", token);
        return "";
    }

    private boolean isEmailTaken(String email) {
        return Boolean.TRUE.equals(userService.isEmailExists(email));
    }

    private boolean isUsernameTaken(String userName) {
        return Boolean.TRUE.equals(userService.isUserExists(userName));
    }


}
