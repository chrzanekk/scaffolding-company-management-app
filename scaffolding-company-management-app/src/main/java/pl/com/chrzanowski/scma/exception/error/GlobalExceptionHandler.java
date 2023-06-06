package pl.com.chrzanowski.scma.exception.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandling(Exception e, WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.builder()
                .timestamp(new Date())
                .message(e.getMessage())
                .details(request.getDescription(false)).build(),
                HttpStatus.BAD_REQUEST);
    }
}
