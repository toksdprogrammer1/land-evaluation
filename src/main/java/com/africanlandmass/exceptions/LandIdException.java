package com.africanlandmass.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LandIdException extends RuntimeException {

    public LandIdException(String message) {
        super(message);
    }
}
