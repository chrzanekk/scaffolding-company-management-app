package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.ConfirmationToken;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.model.UserDTO;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.service.RegistrationService;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.util.EmailValidator;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final RoleService roleService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenServiceImpl confirmationTokenService;

    @Override
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid!");
        }
        return userService.createUser(
                new UserDTO(
                        request.getEmail().toLowerCase(Locale.ROOT),
                        request.getFirstName(),
                        request.getSecondName(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        false,
                        false,
                        assignRoles()
                ));
    }
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken =
                confirmationTokenService.getToken(token).orElseThrow(() -> new IllegalStateException("Token not " +
                        "found"));
        if(confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed!");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }

    private Set<Role> assignRoles() {
        Set<Role> userRoles = new HashSet<>();
        List<User> users = userService.findAll();
        if(users.isEmpty()) {
            userRoles.add(roleService.findByName(ERole.ROLE_ADMIN).get());
        } else {
            userRoles.add(roleService.findByName(ERole.ROLE_USER).get());
        }
        return userRoles;
    }

}
