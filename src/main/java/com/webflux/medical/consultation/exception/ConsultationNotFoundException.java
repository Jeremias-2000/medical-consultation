package com.webflux.medical.consultation.exception;

public class ConsultationNotFoundException extends RuntimeException{
    public ConsultationNotFoundException(String consultationId) {
        super(consultationId);
    }
}
