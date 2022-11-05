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
public class UserDTO {

    private Long id;
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

    public static final class UserDTOBuilder {
        private Long id;
        private String providerUserId;
        private @NotEmpty(message = "Email should not be empty") String email;
        private String firstName;
        private String secondName;
        private @NotEmpty(message = "Password should not be empty") String passwordHash;
        private Boolean isEnabled;
        private LocalDateTime registrationDate;
        private LocalDateTime deleteDateTime;
        private LocalDateTime modifyDateTime;
        private String provider;

        private UserDTOBuilder() {
        }

        public static UserDTOBuilder anUserDTO() {
            return new UserDTOBuilder();
        }

        public UserDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder withProviderUserId(String providerUserId) {
            this.providerUserId = providerUserId;
            return this;
        }

        public UserDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserDTOBuilder withPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public UserDTOBuilder withIsEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public UserDTOBuilder withRegistrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public UserDTOBuilder withDeleteDateTime(LocalDateTime deleteDateTime) {
            this.deleteDateTime = deleteDateTime;
            return this;
        }

        public UserDTOBuilder withModifyDateTime(LocalDateTime modifyDateTime) {
            this.modifyDateTime = modifyDateTime;
            return this;
        }

        public UserDTOBuilder withProvider(String provider) {
            this.provider = provider;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(id);
            userDTO.setProviderUserId(providerUserId);
            userDTO.setEmail(email);
            userDTO.setFirstName(firstName);
            userDTO.setSecondName(secondName);
            userDTO.setPasswordHash(passwordHash);
            userDTO.setIsEnabled(isEnabled);
            userDTO.setRegistrationDate(registrationDate);
            userDTO.setDeleteDateTime(deleteDateTime);
            userDTO.setModifyDateTime(modifyDateTime);
            userDTO.setProvider(provider);
            return userDTO;
        }
    }
}
