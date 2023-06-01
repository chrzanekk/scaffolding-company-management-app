package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.repository.RoleRepository;
import pl.com.chrzanowski.scma.repository.UserRepository;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.UserDTO;
import pl.com.chrzanowski.scma.service.filter.user.UserFilter;
import pl.com.chrzanowski.scma.service.filter.user.UserSpecification;
import pl.com.chrzanowski.scma.service.mapper.UserMapper;
import pl.com.chrzanowski.scma.util.FieldValidator;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final static String USER_NOT_FOUND = "user with email %s not found";

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.info("Saving new user {} to database", userDTO);
        FieldValidator.validateObject(userDTO, "userDTO");
        validateUserDTO(userDTO);
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.info("Update user {} to database", userDTO);
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> findByFilter(UserFilter filter) {
        log.debug("Find all users by filter: {}", filter);
        Specification<User> specification = UserSpecification.create(filter);
        return userMapper.toDto(userRepository.findAll(specification));
    }

    @Override
    public Page<UserDTO> findByFilterAndPage(UserFilter filter, Pageable pageable) {
        log.debug("Find all users by filter and page: {}", filter);
        Specification<User> specification = UserSpecification.create(filter);
        return userRepository.findAll(specification, pageable).map(userMapper::toDto);
    }

    @Override
    public UserDTO findById(Long id) {
        log.debug("Find user by id: {}", id);
        Optional<User> optionalUser = userRepository.findById(id);
        return userMapper.toDto(optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete user by id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        log.info("Fetching all users. ");
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public void addRoleToUser(String email, ERole roleName) {
        log.info("Assigning new role {} to user {}", roleName, email);
        Optional<User> user = userRepository.findByEmail(email);
        Optional<Role> role = roleRepository.findByName(roleName);
        if (user.isPresent() && role.isPresent()) {
            user.get().getRoles().add(role.get());
        }

    }

    @Override
    public UserDTO getUser(String email) {
        log.info("Fetching user {} ", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
        return userMapper.toDto(user);
    }

    @Override
    public Boolean isUserExists(String userName) {
        log.debug("Request to check if userName exists in DB: {}", userName);
        return userRepository.existsByUsername(userName);
    }

    @Override
    public Boolean isEmailExists(String email) {
        log.debug("Request to check if email exists in DB: {}", email);
        return userRepository.existsByEmail(email);
    }

    private void validateUserDTO(UserDTO userDTO) {
        FieldValidator.validateString(userDTO.getUsername(), "Username");
        FieldValidator.validateString(userDTO.getPassword(), "Password");
        FieldValidator.validateString(userDTO.getEmail(), "E-mail");
    }
}
