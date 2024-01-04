package com.example.restapi.Task.Exception;

public class UserCanNotBeDeleted extends Exception {
    public UserCanNotBeDeleted (String messege) {
        super(messege);
    }
}
