package pl.com.chrzanowski.scma.payload.request;

import javax.validation.constraints.NotNull;

public class PasswordResetRequest {

    private final @NotNull String email;


    public PasswordResetRequest(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
