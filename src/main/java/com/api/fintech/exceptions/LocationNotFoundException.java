package com.api.fintech.exceptions;

public class LocationNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public LocationNotFoundException(String message) {
        super(message);
    }
}
