package com.webflux.medical.consultation.document;

import com.webflux.medical.consultation.enums.Gender;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Doctor {

    @Id
    private String doctorId;

    @NotBlank
    private String fullName;
    @Size(min = 11)
    private String cpf;
    @NotBlank
    @NotNull
    private String crm;
    @Size(max = 1)
    private Gender gender;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;
    @NotBlank
    private MedicalSpeciality medicalSpecialty;
    @Size(max = 38)
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    private String contact;
    @NotBlank
    private Address address;
}
