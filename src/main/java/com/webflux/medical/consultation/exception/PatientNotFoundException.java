package com.webflux.medical.consultation.exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String patientId) {
    }
}
