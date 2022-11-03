package pl.com.chrzanowski.scma.controller.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String email;
    private final String firstName;
    private final String secondName;
    private final String passwordHash;
//    private final String language;
//    private final Boolean regulationAccepted;
//    private final Boolean newsletterAccepted;
//    private final Boolean isEnabled;
//    private final Boolean isEmailConfirmed;
//    private final LocalDateTime registrationDate;
//    private final String registrationIp;
//    private final String registrationUserAgent;
//    private final LocalDateTime deleteDateTime;
}
