package pl.com.chrzanowski.scma.service.impl;


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
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveUser(UserDto userDto) {

        Authority authority = authorityRepository.findByName(AuthoritiesTypes.ADMIN);
        if (authority == null) {
            authority = checkAuthorityExist();
        }
        User user = UserBuilder.anUser()
                .withLogin(userDto.getLogin())
                .withFirstName(userDto.getFirstName())
                .withSecondName(userDto.getSecondName())
                .withPasswordHash(passwordEncoder.encode(userDto.getPasswordHash()))
                .withLanguage(userDto.getLanguage())
                .withRegulationAccepted(userDto.getRegulationAccepted())
                .withNewsletterAccepted(userDto.getNewsletterAccepted())
                .withIsEnabled(userDto.getEnabled())
                .withIsEmailConfirmed(userDto.getEmailConfirmed())
                .withRegistrationDateTime(userDto.getRegistrationDate())
                .withRegistrationIp(userDto.getRegistrationIp())
                .withRegistrationUserAgent(userDto.getRegistrationUserAgent())
                .withAuthorities(List.of(authority))
                .build();

        userRepository.save(user);

    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
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
                .withLogin(user.getLogin())
                .withFirstName(user.getFirstName())
                .withSecondName(user.getSecondName())
                .withLanguage(user.getLanguage())
                .withRegulationAccepted(user.getRegulationAccepted())
                .withNewsletterAccepted(user.getNewsletterAccepted())
                .withIsEnabled(user.getEnabled())
                .withIsEmailConfirmed(user.getEmailConfirmed())
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
}
