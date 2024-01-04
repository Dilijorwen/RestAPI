package com.example.restapi.Task.DTO;

import lombok.*;

@Data
@Builder
public class ErrorDTO extends Exception {
    private String message;
}
