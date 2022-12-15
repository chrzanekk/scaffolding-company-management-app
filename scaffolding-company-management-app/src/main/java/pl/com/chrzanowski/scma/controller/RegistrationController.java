package pl.com.chrzanowski.scma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.service.RegistrationService;

@RestController
@RequestMapping(path = "/api/register")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping()
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
