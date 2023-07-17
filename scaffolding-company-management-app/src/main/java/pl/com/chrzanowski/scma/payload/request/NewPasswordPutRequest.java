package pl.com.chrzanowski.scma.payload.request;

public class NewPasswordPutRequest {
    private String newPasswordHash;
    private String newPasswordHashRepeat;

    public NewPasswordPutRequest(String newPasswordHash,
                                 String newPasswordHashRepeat) {
        this.newPasswordHash = newPasswordHash;
        this.newPasswordHashRepeat = newPasswordHashRepeat;
    }

    public NewPasswordPutRequest() {
    }

    public String getNewPasswordHash() {
        return newPasswordHash;
    }

    public String getNewPasswordHashRepeat() {
        return newPasswordHashRepeat;
    }

    public NewPasswordPutRequest setNewPasswordHash(String newPasswordHash) {
        this.newPasswordHash = newPasswordHash;
        return this;
    }

    public NewPasswordPutRequest setNewPasswordHashRepeat(String newPasswordHashRepeat) {
        this.newPasswordHashRepeat = newPasswordHashRepeat;
        return this;
    }
}
