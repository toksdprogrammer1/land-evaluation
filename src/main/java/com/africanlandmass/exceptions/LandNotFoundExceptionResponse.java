package com.africanlandmass.exceptions;

public class LandNotFoundExceptionResponse {

    private String LandNotFound;

    public LandNotFoundExceptionResponse(String landNotFound) {
        LandNotFound = landNotFound;
    }

    public String getLandNotFound() {
        return LandNotFound;
    }

    public void setlandNotFound(String landNotFound) {
        LandNotFound = landNotFound;
    }
}
