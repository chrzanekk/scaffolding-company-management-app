package pl.com.chrzanowski.scma.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.payload.request.LoginRequest;
import pl.com.chrzanowski.scma.security.jwt.AuthTokenFilter;
import pl.com.chrzanowski.scma.security.jwt.JwtUtils;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
public class UserAuthController {

    private final Logger log = LoggerFactory.getLogger(UserAuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    public UserAuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }


    @PostMapping("/login")
    public ResponseEntity<JWTToken> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        log.debug("REST request to login user {}", loginRequest);
        LoginRequest updatedRequest =
                LoginRequest.builder(loginRequest).username(loginRequest.getUsername().toLowerCase()).build();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(updatedRequest.getUsername(), updatedRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        HttpHeaders headers = new HttpHeaders();
        headers.add(AuthTokenFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new JWTToken(jwt), headers, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok().build();
    }

    static class JWTToken {

        private String tokenValue;

        JWTToken(String tokenValue) {
            this.tokenValue = tokenValue;
        }

        @JsonProperty("id_token")
        String getTokenValue() {
            return tokenValue;
        }

        void setTokenValue(String tokenValue) {
            this.tokenValue = tokenValue;
        }
    }

}
