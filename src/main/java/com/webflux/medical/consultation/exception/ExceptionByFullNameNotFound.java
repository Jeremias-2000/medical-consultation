package com.webflux.medical.consultation.exception;

public class ExceptionByFullNameNotFound extends RuntimeException {
    public ExceptionByFullNameNotFound(String fullName) {
        super(fullName);
    }
}
