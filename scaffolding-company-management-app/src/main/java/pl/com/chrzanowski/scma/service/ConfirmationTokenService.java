package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {

    public void saveConfirmationToken(ConfirmationToken token);

    Optional<ConfirmationToken> getToken(String token);

    public int setConfirmedAt(String token);

}
