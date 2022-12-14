package pl.com.chrzanowski.scma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.service.RegistrationService;
import pl.com.chrzanowski.scma.service.UserService;

@RestController
@RequestMapping(path = "/api/register")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping()
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
