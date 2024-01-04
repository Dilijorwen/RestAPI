package com.example.restapi.Task.DTO;


import lombok.Data;

@Data
public class UserWithoutTasksDTO {
    private Long id;
    private String username;
    private String password;
}
