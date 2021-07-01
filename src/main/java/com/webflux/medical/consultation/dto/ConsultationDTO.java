package com.webflux.medical.consultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDTO {


    private String consultationId;
    @NotBlank(message = "patient Id is cannot be null")
    private  String patientId;
    @NotBlank(message = "doctor Id is cannot be null")
    private String doctorId;
    @NotBlank(message = "appointmentDate is cannot be null")
    private Date appointmentDate;
    @NotBlank(message = "price is cannot be null")
    private String price;

}
