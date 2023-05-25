package pl.com.chrzanowski.scma.service.dto;

import pl.com.chrzanowski.scma.domain.Role;

import java.util.Objects;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private boolean isLocked;
    private boolean isEnabled;
    private Set<Role> roles;

    public UserDTO(Long id, String email, String username, String password, boolean isLocked, boolean isEnabled, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }

    private UserDTO(Builder builder) {
        setId(builder.id);
        setEmail(builder.email);
        setUsername(builder.username);
        setPassword(builder.password);
        setLocked(builder.isLocked);
        setEnabled(builder.isEnabled);
        setRoles(builder.roles);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UserDTO copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.email = copy.getEmail();
        builder.username = copy.getUsername();
        builder.password = copy.getPassword();
        builder.roles = copy.getRoles();
        return builder;
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

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isIsEnabled() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return isLocked == userDTO.isLocked && isEnabled == userDTO.isEnabled && Objects.equals(id, userDTO.id) && Objects.equals(email, userDTO.email) && Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password) && Objects.equals(roles, userDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, isLocked, isEnabled, roles);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                ", isEnabled=" + isEnabled +
                ", roles=" + roles +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String email;
        private String username;
        private String password;
        private boolean isLocked;
        private boolean isEnabled;
        private Set<Role> roles;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder roles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
