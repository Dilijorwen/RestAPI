package com.example.restapi.Task.Exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends RestApiException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
