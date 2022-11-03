package pl.com.chrzanowski.scma.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.UserDto;
import pl.com.chrzanowski.scma.domain.UserDtoBuilder;
import pl.com.chrzanowski.scma.model.Authority;
import pl.com.chrzanowski.scma.model.User;
import pl.com.chrzanowski.scma.model.UserBuilder;
import pl.com.chrzanowski.scma.repository.AuthorityRepository;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.security.AuthoritiesTypes;
import pl.com.chrzanowski.scma.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {

        Authority authority = authorityRepository.findByName(AuthoritiesTypes.ADMIN);
        if (authority == null) {
            authority = checkAuthorityExist();
        }
        User user = UserBuilder.anUser()
                .withEmail(userDto.getEmail())
                .withFirstName(userDto.getFirstName())
                .withSecondName(userDto.getSecondName())
                .withPasswordHash(passwordEncoder.encode(userDto.getPasswordHash()))
                .withLanguage(userDto.getLanguage())
                .withRegulationAccepted(userDto.getRegulationAccepted())
                .withNewsletterAccepted(userDto.getNewsletterAccepted())
                .withIsEnabled(userDto.getIsEnabled())
                .withIsEmailConfirmed(userDto.getIsEmailConfirmed())
                .withRegistrationDateTime(userDto.getRegistrationDate())
                .withRegistrationIp(userDto.getRegistrationIp())
                .withRegistrationUserAgent(userDto.getRegistrationUserAgent())
                .withAuthorities(List.of(authority))
                .build();

        userRepository.save(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        return UserDtoBuilder.anUserDto()
                .withEmail(user.getEmail())
                .withFirstName(user.getFirstName())
                .withSecondName(user.getSecondName())
                .withLanguage(user.getLanguage())
                .withRegulationAccepted(user.getRegulationAccepted())
                .withNewsletterAccepted(user.getNewsletterAccepted())
                .withIsEnabled(user.getIsEnabled())
                .withIsEmailConfirmed(user.getIsEmailConfirmed())
                .withRegistrationDate(user.getRegistrationDateTime())
                .withRegistrationIp(user.getRegistrationIp())
                .withRegistrationUserAgent(user.getRegistrationUserAgent())
                .build();
    }

    private Authority checkAuthorityExist() {
        Authority authority = new Authority();
        authority.setName(AuthoritiesTypes.ADMIN);
        return authorityRepository.save(authority);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
