package pl.com.chrzanowski.scma.payload.request;

public class NewPasswordPutRequest {
    private final String newPasswordHash;
    private final String token;

    public NewPasswordPutRequest(String newPasswordHash, String token) {
        this.newPasswordHash = newPasswordHash;
        this.token = token;
    }

    public String getNewPasswordHash() {
        return newPasswordHash;
    }

    public String getToken() {
        return token;
    }
}
