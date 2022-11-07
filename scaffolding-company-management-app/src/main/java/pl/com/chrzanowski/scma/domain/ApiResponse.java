package pl.com.chrzanowski.scma.domain;

import lombok.Value;

@Value
public class ApiResponse {
    private Boolean success;
    private String message;
}
