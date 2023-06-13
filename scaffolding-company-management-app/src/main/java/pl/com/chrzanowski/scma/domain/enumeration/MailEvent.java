package pl.com.chrzanowski.scma.domain.enumeration;

public enum MailEvent {
    AFTER_REGISTRATION("r"),
    AFTER_PASSWORD_CHANGE("p"),
    PASSWORD_RESET("n"),
    EMAIL_CONFIRMATION_LINK("c");

    private String code;

    MailEvent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
