package com.example.restapi.Task.Exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String messege){
        super(messege);
    }
}
