package pl.com.chrzanowski.scma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
