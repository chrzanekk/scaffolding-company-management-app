package pl.com.chrzanowski.scma.exception;

public class UserAlreadyExistsAuthenticationException extends RuntimeException {

    private static final long serialVersionUID = 3333L;

    public UserAlreadyExistsAuthenticationException(final String message) {
        super(message);
    }
}
