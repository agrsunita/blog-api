package com.example.blogapi.exception;

public class BlogAlreadyExistsException extends RuntimeException{
    private String message;
    public BlogAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
//    public BlogAlreadyExistsException(){};
}
