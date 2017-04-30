package com.khalid.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

    public static ResponseEntity<String> createResponseEntity(String message, HttpStatus statusCode){
        return new ResponseEntity<>(message, statusCode);
    }

}
