package pl.com.chrzanowski.scma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.payload.request.RegistrationRequest;
import pl.com.chrzanowski.scma.service.UserService;

@RestController
@RequestMapping(path = "api/user")
@AllArgsConstructor
public class UserController {

    private static UserService userService;

    public String register(@RequestBody RegistrationRequest request) {
        return userService.register(request);
    }
}
