package pl.com.chrzanowski.scma.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_user_id")
    private String providerUserId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "email_confirmed")
    private Boolean isEmailConfirmed;

    @Column(name = "registration_datetime")
    private LocalDateTime registrationDateTime;

    @Column(name = "modified_datetime")
    private LocalDateTime modifiedDateTime;

    @Column(name = "delete_datetime")
    private LocalDateTime deleteDateTime;

    @Column(name = "provider")
    private String provider;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;


    public static final class UserBuilder {
        private Long id;
        private String providerUserId;
        private String email;
        private String firstName;
        private String secondName;
        private String passwordHash;
        private Boolean isEnabled;
        private Boolean isEmailConfirmed;
        private LocalDateTime registrationDateTime;
        private LocalDateTime modifiedDateTime;
        private LocalDateTime deleteDateTime;
        private String provider;
        private Set<Authority> authorities;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withProviderUserId(String providerUserId) {
            this.providerUserId = providerUserId;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder withPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public UserBuilder withIsEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public UserBuilder withIsEmailConfirmed(Boolean isEmailConfirmed) {
            this.isEmailConfirmed = isEmailConfirmed;
            return this;
        }

        public UserBuilder withRegistrationDateTime(LocalDateTime registrationDateTime) {
            this.registrationDateTime = registrationDateTime;
            return this;
        }

        public UserBuilder withModifiedDateTime(LocalDateTime modifiedDateTime) {
            this.modifiedDateTime = modifiedDateTime;
            return this;
        }

        public UserBuilder withDeleteDateTime(LocalDateTime deleteDateTime) {
            this.deleteDateTime = deleteDateTime;
            return this;
        }

        public UserBuilder withProvider(String provider) {
            this.provider = provider;
            return this;
        }

        public UserBuilder withAuthorities(Set<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setProviderUserId(providerUserId);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setPasswordHash(passwordHash);
            user.setIsEnabled(isEnabled);
            user.setIsEmailConfirmed(isEmailConfirmed);
            user.setRegistrationDateTime(registrationDateTime);
            user.setModifiedDateTime(modifiedDateTime);
            user.setDeleteDateTime(deleteDateTime);
            user.setProvider(provider);
            user.setAuthorities(authorities);
            return user;
        }
    }
}
