package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.service.UserService;
import pl.com.chrzanowski.scma.service.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final UserService userService;


    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public UserDTO getAccount() {
        return userService.getUserWithAuthorities();
    }

    @PostMapping("/save")
    public void saveAccount(@Valid @RequestBody UserDTO userDTO) {
        //todo implement save updated user info
    }

    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        log.debug("REST request to check if the current user is authenticated");
        return request.getRemoteUser();
    }


}
