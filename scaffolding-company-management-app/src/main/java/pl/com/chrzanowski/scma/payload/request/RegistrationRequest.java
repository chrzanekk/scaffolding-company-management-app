package pl.com.chrzanowski.scma.payload.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private String firstName;
    private String secondName;
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

}
