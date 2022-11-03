package pl.com.chrzanowski.scma.service;

import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.controller.requests.RegistrationRequest;

@Service
public interface RegistrationService {

    String register(RegistrationRequest request);
}
