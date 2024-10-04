package com.api.exception;
// here we extend runtime exception for handling exception
// this code re fix syntax always right the same code for exception

public class ResourceNotFoundException extends RuntimeException {

    // generating  constructor of this class
    public ResourceNotFoundException (String msg){
        super(msg);
    }
}
