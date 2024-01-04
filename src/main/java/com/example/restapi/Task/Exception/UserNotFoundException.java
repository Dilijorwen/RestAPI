package com.example.restapi.Task.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RestApiException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
