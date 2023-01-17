package pl.com.chrzanowski.scma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.com.chrzanowski.scma.domain.Role;

import java.util.Set;

@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private boolean isLocked;
    private boolean isEnabled;
    private Set<Role> roles;

    public UserDTO(String email,
                   String username,
                   String password,
                   boolean isLocked,
                   boolean isEnabled,
                   Set<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
