package com.example.restapi.Task.Exception;

import org.springframework.http.HttpStatus;

public class UserCanNotBeDeleted extends RestApiException {
    public UserCanNotBeDeleted (String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
