package com.webflux.medical.consultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class MedicalRecordDTO {

    private String medicalRecordId;

    private String patientId;
    private String limitation;
    private String allergy;
    private String medicalRecordNumber;
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    private Date openingDate;
}
