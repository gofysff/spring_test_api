package com.example.demo.exception;

public class UserNotFoundedException  extends Exception{
    public UserNotFoundedException(String message){
        super(message);
    }
}
