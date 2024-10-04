package com.api.exception;
// here we handel the throws exception

import com.api.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // this will handel only resource not found exception
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFound(
        ResourceNotFoundException r,
        // use to get url of error
        WebRequest request
    ){
        // create obj of error dto and call pass the value
        ErrorDto dtoError = new ErrorDto(r.getMessage(),new Date(),
                          request.getDescription(false));

        return new  ResponseEntity<>(dtoError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // This will handel any type of exception in project
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handelGlobalException(
            Exception e
    ){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

