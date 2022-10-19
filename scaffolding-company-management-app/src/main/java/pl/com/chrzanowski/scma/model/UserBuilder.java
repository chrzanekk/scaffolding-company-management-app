package pl.com.chrzanowski.scma.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public final class UserBuilder {
    private Long id;
    private String login;
    private String firstName;
    private String secondName;
    private String passwordHash;
    private String language;
    private Boolean regulationAccepted;
    private Boolean newsletterAccepted;
    private Boolean isEnabled;
    private Boolean isEmailConfirmed;
    private LocalDateTime registrationDateTime;
    private String registrationIp;
    private String registrationUserAgent;
    private LocalDateTime deleteDateTime;
    private List<Authority> authorities;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
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

    public UserBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    public UserBuilder withRegulationAccepted(Boolean regulationAccepted) {
        this.regulationAccepted = regulationAccepted;
        return this;
    }

    public UserBuilder withNewsletterAccepted(Boolean newsletterAccepted) {
        this.newsletterAccepted = newsletterAccepted;
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

    public UserBuilder withRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
        return this;
    }

    public UserBuilder withRegistrationUserAgent(String registrationUserAgent) {
        this.registrationUserAgent = registrationUserAgent;
        return this;
    }

    public UserBuilder withDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
        return this;
    }

    public UserBuilder withAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public User build() {
        return new User(id, login, firstName, secondName, passwordHash, language, regulationAccepted, newsletterAccepted, isEnabled, isEmailConfirmed, registrationDateTime, registrationIp, registrationUserAgent, deleteDateTime, authorities);
    }
}
