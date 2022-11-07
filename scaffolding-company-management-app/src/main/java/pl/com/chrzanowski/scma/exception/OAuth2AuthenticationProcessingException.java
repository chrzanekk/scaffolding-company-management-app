package pl.com.chrzanowski.scma.exception;


import org.springframework.security.core.AuthenticationException;

public class OAuth2AuthenticationProcessingException extends AuthenticationException {
    private static final long serialVersionUID = 1111L;


    public OAuth2AuthenticationProcessingException(String message) {
        super(message);
    }

    public OAuth2AuthenticationProcessingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
