package pl.com.chrzanowski.scma.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.RegistrationRequest;
import pl.com.chrzanowski.scma.domain.LocalUser;
import pl.com.chrzanowski.scma.exception.UserAlreadyExistsAuthenticationException;
import pl.com.chrzanowski.scma.model.User;
import pl.com.chrzanowski.scma.repository.AuthorityRepository;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User registerNewUser(final RegistrationRequest request) throws UserAlreadyExistsAuthenticationException {
        if(request.getId)
        return null;
    }

    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
        return null;
    }
}

