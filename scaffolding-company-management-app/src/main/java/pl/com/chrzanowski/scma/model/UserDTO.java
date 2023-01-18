package pl.com.chrzanowski.scma.model;

import pl.com.chrzanowski.scma.domain.Role;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (isLocked != userDTO.isLocked) return false;
        if (isEnabled != userDTO.isEnabled) return false;
        if (id != null ? !id.equals(userDTO.id) : userDTO.id != null) return false;
        if (email != null ? !email.equals(userDTO.email) : userDTO.email != null) return false;
        if (username != null ? !username.equals(userDTO.username) : userDTO.username != null) return false;
        if (password != null ? !password.equals(userDTO.password) : userDTO.password != null) return false;
        return roles != null ? roles.equals(userDTO.roles) : userDTO.roles == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isLocked ? 1 : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
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

        public static Builder builder() {
            return new Builder();
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
