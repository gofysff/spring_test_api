package com.example.demo.exception;


public class TodoNotFoundedException  extends Exception{
    public TodoNotFoundedException(String message){
        super(message);
    }
}