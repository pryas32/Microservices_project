package com.Icwd.user.service.exceptions;

import com.Icwd.user.service.payload.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice//jiisee yeh pure project ka ek centralized exception handler ban jaaye kahi bhi exception aati hain toh ham yaha handle kar sakte hain
public class GlobalEExceptionHandler {

    //agar error aa jaati hain toh yeh wala method chalega with status code

 @ExceptionHandler(ResourceNotFoundException.class)//puri project me yeh wali exception generate hogi toh niche wala method chal jayega
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){

     String message=ex.getMessage();
     ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

     return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);

    }




}
