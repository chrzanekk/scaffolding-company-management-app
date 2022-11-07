package pl.com.chrzanowski.scma.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private Long id;
    private String providerUserId;
    @NotEmpty(message = "Email should not be empty")
    private String email;
    private String firstName;
    private String secondName;
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 8, message = "{Size.userDto.password")
    private String passwordHash;
    @NotEmpty
    private String matchingPassword;
    private Boolean isEnabled;
    private LocalDateTime registrationDate;
    private LocalDateTime deleteDateTime;
    private LocalDateTime modifyDateTime;
    private SocialProvider socialProvider;

    public RegistrationRequest(String providerUserId, String firstName, String secondName, String email,
                               String passwordHash, SocialProvider socialProvider) {
        this.providerUserId = providerUserId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.socialProvider = socialProvider;
    }


    public static final class Builder {
        private Long id;
        private String providerUserId;
        private @NotEmpty(message = "Email should not be empty") String email;
        private String firstName;
        private String secondName;
        private @NotEmpty(message = "Password should not be empty") @Size(min = 8, message = "{Size.userDto.password") String passwordHash;
        private @NotEmpty String matchingPassword;
        private Boolean isEnabled;
        private LocalDateTime registrationDate;
        private LocalDateTime deleteDateTime;
        private LocalDateTime modifyDateTime;
        private SocialProvider socialProvider;

        private Builder() {
        }

        public static Builder aRegistrationRequest() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withProviderUserId(String providerUserId) {
            this.providerUserId = providerUserId;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder withPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public Builder withMatchingPassword(String matchingPassword) {
            this.matchingPassword = matchingPassword;
            return this;
        }

        public Builder withIsEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder withRegistrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder withDeleteDateTime(LocalDateTime deleteDateTime) {
            this.deleteDateTime = deleteDateTime;
            return this;
        }

        public Builder withModifyDateTime(LocalDateTime modifyDateTime) {
            this.modifyDateTime = modifyDateTime;
            return this;
        }

        public Builder withSocialProvider(SocialProvider socialProvider) {
            this.socialProvider = socialProvider;
            return this;
        }

        public RegistrationRequest build() {
            return new RegistrationRequest(id, providerUserId, email, firstName, secondName, passwordHash, matchingPassword, isEnabled, registrationDate, deleteDateTime, modifyDateTime, socialProvider);
        }
    }
}
