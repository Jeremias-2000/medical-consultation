package com.webflux.medical.consultation.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    @Id
    private String medicalRecordId;

    private String patientId;
    private String limitation;
    private String allergy;
    private String medicalRecordNumber;
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    private Date openingDate;
}
