package com.example.swagger2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SwaggerException extends Exception {
    public SwaggerException(String message) {
        super(message);
    }
}
