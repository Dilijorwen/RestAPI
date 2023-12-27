package com.example.restapi.Task.Exception;

public class UserCannotBeDeleted extends Exception {
    public UserCannotBeDeleted(String messege){
        super(messege);
    }
}