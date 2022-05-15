package com.gowthamy.userservice.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class UserServiceException extends RuntimeException {
    private final UserServiceError error;
    private final String additionalErrorDetails;
}
