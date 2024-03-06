package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.exception.EmailAlreadyExistsException;
import pl.com.chrzanowski.scma.exception.EmailNotFoundException;
import pl.com.chrzanowski.scma.exception.PasswordNotMatchException;
import pl.com.chrzanowski.scma.exception.UsernameAlreadyExistsException;
import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.request.RegisterRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.security.jwt.JwtUtils;
import pl.com.chrzanowski.scma.service.*;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;
import pl.com.chrzanowski.scma.service.dto.PasswordResetTokenDTO;
import pl.com.chrzanowski.scma.service.dto.UserDTO;
import pl.com.chrzanowski.scma.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Value("${tokenValidityTimeInMinutes}")
    private Long tokenValidityTimeInMinutes;

    private final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;
    private final PasswordResetTokenService passwordResetTokenService;
    private final PasswordResetService passwordResetService;
    private final SentEmailService sentEmailService;

    public AccountController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService, ConfirmationTokenService confirmationTokenService, PasswordResetTokenService passwordResetTokenService, PasswordResetService passwordResetService, SentEmailService sentEmailService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
        this.confirmationTokenService = confirmationTokenService;
        this.passwordResetTokenService = passwordResetTokenService;
        this.passwordResetService = passwordResetService;
        this.sentEmailService = sentEmailService;
    }

    @GetMapping("/get")
    public UserDTO getAccount() {
        return userService.getUserWithAuthorities();
    }

    @PostMapping("/save")
    public void saveAccount(@Valid @RequestBody UserDTO userDTO) {
        //todo implement save updated user info
    }

    //todo implement endpoints to reset password by user(init and finish)-> maybe i should move from auth controller,
    //todo implement activation endpoint
    //todo implement/move registration endpoint here

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

        TokenUtil.validateTokenTime(confirmationTokenDTO.getCreateDate(), tokenValidityTimeInMinutes);
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
    public ResponseEntity<?> newPasswordPut(@RequestParam("token") String token,
                                            @RequestBody NewPasswordPutRequest request) {
        log.debug("REST request to set new password by token: {}", token);
        validatePasswordMatch(request);
        PasswordResetTokenDTO passwordResetTokenDTO = passwordResetTokenService.get(token);

        TokenUtil.validateTokenTime(passwordResetTokenDTO.getCreateDate(), tokenValidityTimeInMinutes);
        MessageResponse response = passwordResetService.saveNewPassword(passwordResetTokenDTO, request);
        sentEmailService.sendAfterPasswordChange(passwordResetTokenDTO, new Locale("pl"));
        return ResponseEntity.ok().body(response);
    }



    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        log.debug("REST request to check if the current user is authenticated");
        return request.getRemoteUser();
    }

    private boolean isEmailTaken(String email) {
        return Boolean.TRUE.equals(userService.isEmailExists(email));
    }

    private boolean isUsernameTaken(String userName) {
        return Boolean.TRUE.equals(userService.isUserExists(userName));
    }

    private void validatePasswordMatch(NewPasswordPutRequest request) {
        if (!request.getNewPasswordHash().equals(request.getNewPasswordHashRepeat())) {
            throw new PasswordNotMatchException("Password not match");
        }
    }
}
