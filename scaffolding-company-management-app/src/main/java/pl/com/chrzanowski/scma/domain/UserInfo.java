package pl.com.chrzanowski.scma.domain;

import lombok.Value;

import java.util.List;

@Value
public class UserInfo {
    private String id, firstName, secondName, email;
    private List<String> authorities;
}
