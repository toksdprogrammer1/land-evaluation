package com.africanlandmass.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LandNotFoundException extends RuntimeException {
    public LandNotFoundException(String message) {
        super(message);
    }
}
