package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.ConfirmationToken;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.model.UserDTO;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.service.ConfirmationTokenService;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.mapper.UserMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";

    private final UserRepository userRepository;

    private final ConfirmationTokenService confirmationTokenService;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,
                email)));
    }


    @Override
    public String createUser(UserDTO user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        User savedUser = userRepository.save(userMapper.userDTOtoUser(user));
        //TODO: validate and create user roles -> save to DB

        String token = UUID.randomUUID().toString();
        //TODO: Send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                savedUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: send email
        return token;
    }

    @Override
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
