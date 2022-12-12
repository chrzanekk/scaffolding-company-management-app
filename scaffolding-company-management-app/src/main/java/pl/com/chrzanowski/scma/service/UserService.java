package pl.com.chrzanowski.scma.service;


import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;

public interface UserService {

    String register(RegistrationRequest request);
}
