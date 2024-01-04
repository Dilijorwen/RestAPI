package com.example.restapi.Task.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorResponseDTO {
    private ErrorDTO error;

}
