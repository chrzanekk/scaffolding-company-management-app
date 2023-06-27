package pl.com.chrzanowski.scma.payload.request;

public class PasswordResetRequest {

    private final String email;


    public PasswordResetRequest(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
