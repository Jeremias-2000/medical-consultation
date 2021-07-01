package com.webflux.medical.consultation.exception;

public class exceptionPerExistingPatient extends RuntimeException {
    public exceptionPerExistingPatient(String message) {
        super(message);
    }
}
