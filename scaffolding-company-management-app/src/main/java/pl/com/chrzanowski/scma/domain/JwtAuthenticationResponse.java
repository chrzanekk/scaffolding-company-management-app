package pl.com.chrzanowski.scma.domain;

import lombok.Value;

@Value
public class JwtAuthenticationResponse {
    private String accessToken;
    private UserInfo user;
}
