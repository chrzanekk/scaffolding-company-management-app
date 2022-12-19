package pl.com.chrzanowski.scma.service.mapper;

import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.model.UserDTO;

@Service
public class UserMapper {

    public User userDTOtoUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setFirstName(userDTO.getFirstName());
            user.setSecondName(userDTO.getSecondName());
            user.setPassword(userDTO.getPassword());
            user.setLocked(userDTO.isLocked());
            user.setEnabled(userDTO.isEnabled());
            user.setRoles(userDTO.getRoles());
            return user;
        }
    }
}
