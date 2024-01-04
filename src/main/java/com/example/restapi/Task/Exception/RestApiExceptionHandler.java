package com.example.restapi.Task.Exception;


import com.example.restapi.Task.DTO.ErrorDTO;
import com.example.restapi.Task.DTO.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleException(UserNotFoundException e) {
        var error = ErrorDTO.builder().message(e.getMessage()).build();
        var result = new ErrorResponseDTO().setError(error);

        return ResponseEntity.status(e.getHttpStatus()).body(result);
    }

    @ExceptionHandler(UserCanNotBeDeleted.class)
    public ResponseEntity<?> handleException(UserCanNotBeDeleted e) {
        var error = ErrorDTO.builder().message(e.getMessage()).build();
        var result = new ErrorResponseDTO().setError(error);

        return ResponseEntity.status(e.getHttpStatus()).body(result);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleException(UserAlreadyExistException e) {
        var error = ErrorDTO.builder().message(e.getMessage()).build();
        var result = new ErrorResponseDTO().setError(error);

        return ResponseEntity.status(e.getHttpStatus()).body(result);
    }
}
