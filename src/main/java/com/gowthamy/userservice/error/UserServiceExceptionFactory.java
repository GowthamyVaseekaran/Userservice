package com.gowthamy.userservice.error;

public class UserServiceExceptionFactory {

    private UserServiceExceptionFactory() {}

    public static UserServiceException genericError(String errorMessage) {
        return new UserServiceException(UserServiceError.GENERIC_ERROR_OCCURRED, errorMessage);
    }
}
