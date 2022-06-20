package com.example.blogapi.exception;

public class BlogNotFoundException extends RuntimeException{
    private String message;
    private int postId;
    public BlogNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public  BlogNotFoundException(String s, int postId) {
        super(s+postId);
        this.message = s;
        this.postId = postId;

    }
}
