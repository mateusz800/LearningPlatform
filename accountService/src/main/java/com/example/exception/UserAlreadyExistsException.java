package com.example.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(){
        super("User with given email already exists");
    }
}
