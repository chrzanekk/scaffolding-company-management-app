package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.UserDTO;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.service.RegistrationService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.util.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid!");
        }
        return userService.createNewUser(
                new UserDTO(
                        request.getEmail(),
                        request.getFirstName(),
                        request.getSecondName(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        false,
                        true,
                        null
                ));
    }

}
