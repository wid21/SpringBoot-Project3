package com.example.springbootproject3.ApiException;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
