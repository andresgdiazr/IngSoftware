package com.api.fintech.exceptions;

public class CompanyNotFoundException extends Throwable {
    private static final long serialVersionUID = 1L;

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
