package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.ConfirmationToken;
import pl.com.chrzanowski.scma.repository.ConfirmationTokenRepository;
import pl.com.chrzanowski.scma.service.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }


}
