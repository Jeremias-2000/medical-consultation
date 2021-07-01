package com.webflux.medical.consultation.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

    @Id
    private String consultationId;

    @NotBlank
    private  String patientId;
    @NotBlank
    private String doctorId;
    @NotBlank
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    private Date appointmentDate;
    @NotBlank
    private String price;

}
