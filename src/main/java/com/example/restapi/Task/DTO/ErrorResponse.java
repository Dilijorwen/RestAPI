package com.example.restapi.Task.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final HttpStatus status;
    private final String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyYY-MM-dd HH:mm:ss")
    private final LocalDateTime time = LocalDateTime.now();
    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

