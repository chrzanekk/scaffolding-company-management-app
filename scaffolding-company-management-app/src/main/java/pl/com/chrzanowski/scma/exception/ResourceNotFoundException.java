package pl.com.chrzanowski.scma.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2222L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
    }

}
