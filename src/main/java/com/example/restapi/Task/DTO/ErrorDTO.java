package com.example.restapi.Task.DTO;

import lombok.*;

@Data
public class ErrorDTO extends Exception {
    public ErrorDTO (String messege){
        super(messege);
    }
}
