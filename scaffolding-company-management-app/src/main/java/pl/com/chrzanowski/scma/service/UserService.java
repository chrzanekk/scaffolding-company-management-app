package pl.com.chrzanowski.scma.service;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import pl.com.chrzanowski.scma.domain.RegistrationRequest;
import pl.com.chrzanowski.scma.domain.LocalUser;
import pl.com.chrzanowski.scma.exception.UserAlreadyExistsAuthenticationException;
import pl.com.chrzanowski.scma.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    public User registerNewUser(RegistrationRequest request) throws UserAlreadyExistsAuthenticationException;

    User findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    List<User> findAllUsers();

    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
