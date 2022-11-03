package pl.com.chrzanowski.scma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.controller.requests.RegistrationRequest;
import pl.com.chrzanowski.scma.service.RegistrationService;

@RestController
@RequestMapping(params = "api/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
