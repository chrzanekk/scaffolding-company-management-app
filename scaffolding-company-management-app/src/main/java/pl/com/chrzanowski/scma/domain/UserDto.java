package pl.com.chrzanowski.scma.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "Email should not be empty")
    private String email;
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



}
