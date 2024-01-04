package com.example.restapi.Task.Exception;


import com.example.restapi.Task.DTO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class RestApiExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> standardException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse apiException(RestApiException e){
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
