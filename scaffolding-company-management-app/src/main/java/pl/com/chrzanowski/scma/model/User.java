package pl.com.chrzanowski.scma.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

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

    public User() {
    }

    public User(Long id,
                String login,
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
        this.id = id;
        this.login = login;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getRegulationAccepted() {
        return regulationAccepted;
    }

    public void setRegulationAccepted(Boolean regulationAccepted) {
        this.regulationAccepted = regulationAccepted;
    }

    public Boolean getNewsletterAccepted() {
        return newsletterAccepted;
    }

    public void setNewsletterAccepted(Boolean newsletterAccepted) {
        this.newsletterAccepted = newsletterAccepted;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void setEmailConfirmed(Boolean emailConfirmed) {
        isEmailConfirmed = emailConfirmed;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public String getRegistrationIp() {
        return registrationIp;
    }

    public void setRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
    }

    public String getRegistrationUserAgent() {
        return registrationUserAgent;
    }

    public void setRegistrationUserAgent(String registrationUserAgent) {
        this.registrationUserAgent = registrationUserAgent;
    }

    public LocalDateTime getDeleteDateTime() {
        return deleteDateTime;
    }

    public void setDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
