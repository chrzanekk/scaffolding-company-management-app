package pl.com.chrzanowski.scma.service.filter.user;

public class UserFilter {

    private Long id;
    private String emailStartsWith;
    private String usernameStartsWith;
    private boolean isLocked;
    private boolean isEnabled;

    public UserFilter() {
    }

    public Long getId() {
        return id;
    }

    public UserFilter setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmailStartsWith() {
        return emailStartsWith;
    }

    public UserFilter setEmailStartsWith(String emailStartsWith) {
        this.emailStartsWith = emailStartsWith;
        return this;
    }

    public String getUsernameStartsWith() {
        return usernameStartsWith;
    }

    public UserFilter setUsernameStartsWith(String usernameStartsWith) {
        this.usernameStartsWith = usernameStartsWith;
        return this;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public UserFilter setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public UserFilter setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }
}
