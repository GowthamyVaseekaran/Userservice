package com.gowthamy.userservice.error;

import com.gowthamy.userservice.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleAll(ConstraintViolationException ex) {
        logger.error("A User Service App error has occurred", ex);
        Map<String, String> errors = ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessageTemplate));

        var errorResponse = ErrorResponse.builder()
                .httpStatusCode(HttpStatus.NOT_ACCEPTABLE.value())
                .code("E102")
                .fieldErrors(errors)
                .build();

        log.info("Returning error response [{}]", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<Object> handleAll(UserServiceException ex) {
        logger.error("A User Service App error has occurred", ex);
        UserServiceError error = ex.getError();
        var errorResponse = ErrorResponse.builder()
                .code(error.getErrorCode())
                .message(error.getErrorMessage())
                .additionalErrorDetails(ex.getAdditionalErrorDetails())
                .httpStatusCode(error.getHttpStatusCode().value())
                .build();
        log.info("Returning error response [{}]", errorResponse);
        return new ResponseEntity<>(errorResponse, error.getHttpStatusCode());
    }
}
