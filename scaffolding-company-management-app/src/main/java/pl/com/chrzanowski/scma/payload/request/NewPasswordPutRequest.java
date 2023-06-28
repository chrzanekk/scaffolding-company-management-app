package pl.com.chrzanowski.scma.payload.request;

public class NewPasswordPutRequest {
    private final String newPasswordHash;
    private final String newPasswordHashRepeat;

    public NewPasswordPutRequest(String newPasswordHash, String newPasswordHashRepeat) {
        this.newPasswordHash = newPasswordHash;
        this.newPasswordHashRepeat = newPasswordHashRepeat;
    }

    public String getNewPasswordHash() {
        return newPasswordHash;
    }

    public String getNewPasswordHashRepeat() {
        return newPasswordHashRepeat;
    }
}
