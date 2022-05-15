package com.gowthamy.userservice.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UserServiceError {
    GENERIC_ERROR_OCCURRED("E1001", "A generic error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatusCode;

    UserServiceError(String errorCode, String errorMessage, HttpStatus httpStatusCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }


}
