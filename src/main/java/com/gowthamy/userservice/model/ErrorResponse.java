package com.gowthamy.userservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder @Getter @Setter
public class ErrorResponse {
    private String code;
    private String message;
    private String additionalErrorDetails;
    private int httpStatusCode;
    private Map<String, String> fieldErrors;
}
