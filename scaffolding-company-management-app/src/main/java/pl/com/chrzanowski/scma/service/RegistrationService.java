package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;

public interface RegistrationService {

    String register(RegistrationRequest request);

    String confirmToken(String token);
}
