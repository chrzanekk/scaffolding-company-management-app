package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByLogin(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
    }


    @Override
    public String register(RegistrationRequest request) {
        return "works";
    }
}
