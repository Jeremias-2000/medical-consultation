package com.webflux.medical.consultation.exception;

public class MedicalRecordNotFoundException extends RuntimeException {
    public MedicalRecordNotFoundException(String medicalRecordId) {
        super(medicalRecordId);
    }
}
