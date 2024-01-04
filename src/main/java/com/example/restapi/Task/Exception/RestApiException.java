package com.example.restapi.Task.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestApiException extends RuntimeException{
    private final HttpStatus httpStatus;

    public RestApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
