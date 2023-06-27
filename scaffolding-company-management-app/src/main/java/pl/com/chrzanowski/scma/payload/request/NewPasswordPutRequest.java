package pl.com.chrzanowski.scma.payload.request;

public class NewPasswordPutRequest {
    private final String newPasswordHash;
    private final String newPasswordHashRepeat;
    private final String token;

    public NewPasswordPutRequest(String newPasswordHash, String newPasswordHashRepeat, String token) {
        this.newPasswordHash = newPasswordHash;
        this.newPasswordHashRepeat = newPasswordHashRepeat;
        this.token = token;
    }

    public String getNewPasswordHash() {
        return newPasswordHash;
    }

    public String getNewPasswordHashRepeat() {
        return newPasswordHashRepeat;
    }

    public String getToken() {
        return token;
    }
}
