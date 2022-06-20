package com.example.blogapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends  RuntimeException {
    private String resourceName;
    private String fieldName;
    private int fieldValue;

//    public ResourceNotFound(String resourceName,String fieldName,int fieldValue){
public ResourceNotFound(String resourceName){
//        super(String.format("%s is Not Found for %s with %d : " + resourceName,fieldName,fieldValue));
        super(resourceName);
//        this.resourceName = resourceName;
//        this.fieldName = fieldName;
//        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getFieldValue() {
        return fieldValue;
    }

}
