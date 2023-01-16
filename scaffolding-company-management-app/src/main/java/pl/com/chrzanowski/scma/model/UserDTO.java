package pl.com.chrzanowski.scma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.com.chrzanowski.scma.domain.Role;

import java.util.Set;

@AllArgsConstructor
@Getter
public class UserDTO {
    private String email;
    private String username;
    private String password;
    private boolean isLocked;
    private boolean isEnabled;
    private Set<Role> roles;
}
