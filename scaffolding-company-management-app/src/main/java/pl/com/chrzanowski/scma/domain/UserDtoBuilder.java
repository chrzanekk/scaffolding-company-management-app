package pl.com.chrzanowski.scma.domain;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public final class UserDtoBuilder {
    private Long id;
    private @NotEmpty(message = "Email should not be empty") String email;
    private String firstName;
    private String secondName;
    private @NotEmpty(message = "Password should not be empty") String passwordHash;
    private String language;
    private Boolean regulationAccepted;
    private Boolean newsletterAccepted;
    private Boolean isEnabled;
    private Boolean isEmailConfirmed;
    private LocalDateTime registrationDate;
    private String registrationIp;
    private String registrationUserAgent;
    private LocalDateTime deleteDateTime;

    private UserDtoBuilder() {
    }

    public static UserDtoBuilder anUserDto() {
        return new UserDtoBuilder();
    }

    public UserDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDtoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDtoBuilder withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public UserDtoBuilder withPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public UserDtoBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    public UserDtoBuilder withRegulationAccepted(Boolean regulationAccepted) {
        this.regulationAccepted = regulationAccepted;
        return this;
    }

    public UserDtoBuilder withNewsletterAccepted(Boolean newsletterAccepted) {
        this.newsletterAccepted = newsletterAccepted;
        return this;
    }

    public UserDtoBuilder withIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    public UserDtoBuilder withIsEmailConfirmed(Boolean isEmailConfirmed) {
        this.isEmailConfirmed = isEmailConfirmed;
        return this;
    }

    public UserDtoBuilder withRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public UserDtoBuilder withRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
        return this;
    }

    public UserDtoBuilder withRegistrationUserAgent(String registrationUserAgent) {
        this.registrationUserAgent = registrationUserAgent;
        return this;
    }

    public UserDtoBuilder withDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
        return this;
    }

    public UserDto build() {
        return new UserDto(id, email, firstName, secondName, passwordHash, language, regulationAccepted, newsletterAccepted, isEnabled, isEmailConfirmed, registrationDate, registrationIp, registrationUserAgent, deleteDateTime);
    }
}
