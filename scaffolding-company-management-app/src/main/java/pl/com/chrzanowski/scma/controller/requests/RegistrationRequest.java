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
    private String providerUserId;
    @NotEmpty(message = "Email should not be empty")
    private String email;
    private String firstName;
    private String secondName;
    @NotEmpty(message = "Password should not be empty")
    private String passwordHash;
    private Boolean isEnabled;
    private LocalDateTime registrationDate;
    private LocalDateTime deleteDateTime;
    private LocalDateTime modifyDateTime;
    private String provider;
}
