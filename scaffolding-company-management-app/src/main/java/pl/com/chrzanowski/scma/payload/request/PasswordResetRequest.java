package pl.com.chrzanowski.scma.payload.request;

public class PasswordResetRequest {
    private final String actualPasswordHash;
    private final String newPasswordHash;

    public PasswordResetRequest(String actualPasswordHash, String newPasswordHash) {
        this.actualPasswordHash = actualPasswordHash;
        this.newPasswordHash = newPasswordHash;
    }

    public String getActualPasswordHash() {
        return actualPasswordHash;
    }

    public String getNewPasswordHash() {
        return newPasswordHash;
    }
}
