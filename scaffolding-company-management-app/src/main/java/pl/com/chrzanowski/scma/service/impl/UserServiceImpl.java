package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.UserDTO;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.mapper.UserMapper;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,
                email)));
    }


    @Override
    public String createNewUser(UserDTO user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        userRepository.save(userMapper.userDTOtoUser(user));
        //TODO: validate and create user roles -> save to DB

        //TODO: Send confirmation token

        return "registered";
    }
}
