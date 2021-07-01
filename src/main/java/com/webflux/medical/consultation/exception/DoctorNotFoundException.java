package com.webflux.medical.consultation.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String doctorId) {
    }
}
