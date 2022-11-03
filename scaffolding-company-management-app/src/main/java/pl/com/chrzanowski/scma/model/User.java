package pl.com.chrzanowski.scma.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "password_hash",nullable = false)
    private String passwordHash;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "regulation_accepted")
    private Boolean regulationAccepted;

    @Column(name = "newsletter_accepted")
    private Boolean newsletterAccepted;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "email_confirmed")
    private Boolean isEmailConfirmed;

    @Column(name = "registration_datetime")
    private LocalDateTime registrationDateTime;

    @Column(name = "registration_ip")
    private String registrationIp;

    @Column(name = "registration_user_agent")
    private String registrationUserAgent;

    @Column(name = "delete_datetime")
    private LocalDateTime deleteDateTime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities = new ArrayList<>();

    public User(String email,
                String firstName,
                String secondName,
                String passwordHash,
                String language,
                Boolean regulationAccepted,
                Boolean newsletterAccepted,
                Boolean isEnabled,
                Boolean isEmailConfirmed,
                LocalDateTime registrationDateTime,
                String registrationIp,
                String registrationUserAgent,
                LocalDateTime deleteDateTime,
                List<Authority> authorities) {
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.passwordHash = passwordHash;
        this.language = language;
        this.regulationAccepted = regulationAccepted;
        this.newsletterAccepted = newsletterAccepted;
        this.isEnabled = isEnabled;
        this.isEmailConfirmed = isEmailConfirmed;
        this.registrationDateTime = registrationDateTime;
        this.registrationIp = registrationIp;
        this.registrationUserAgent = registrationUserAgent;
        this.deleteDateTime = deleteDateTime;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
