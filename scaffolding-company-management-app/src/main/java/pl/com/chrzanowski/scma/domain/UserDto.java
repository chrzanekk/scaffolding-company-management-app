package pl.com.chrzanowski.scma.domain;

import pl.com.chrzanowski.scma.model.Authority;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

public class UserDto {

    private Long id;
    @NotEmpty(message = "Email should not be empty")
    private String login;
    private String firstName;
    private String secondName;
    @NotEmpty(message = "Password should not be empty")
    private String passwordHash;
    private String language;
    private Boolean regulationAccepted;
    private Boolean newsletterAccepted;
    private Boolean isEnabled;
    private Boolean isEmailConfirmed;
    private LocalDateTime registrationDate;
    private String registrationIp;
    private String registrationUserAgent;
    private LocalDateTime deleteDateTime;

    public UserDto(Long id,
                   String login,
                   String firstName,
                   String secondName,
                   String passwordHash,
                   String language,
                   Boolean regulationAccepted,
                   Boolean newsletterAccepted,
                   Boolean isEnabled,
                   Boolean isEmailConfirmed,
                   LocalDateTime registrationDate,
                   String registrationIp,
                   String registrationUserAgent,
                   LocalDateTime deleteDateTime) {
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
        this.registrationDate = registrationDate;
        this.registrationIp = registrationIp;
        this.registrationUserAgent = registrationUserAgent;
        this.deleteDateTime = deleteDateTime;
    }

    public UserDto() {
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
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

}
