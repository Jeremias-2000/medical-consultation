package com.webflux.medical.consultation.document;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.webflux.medical.consultation.enums.Gender;
import com.webflux.medical.consultation.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    private String patientId;

    @NotBlank
    private String fullName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private Gender gender;
    @NotBlank
    @Size(min = 11)
    private String cpf;
    @NotBlank
    @Size(min = 7)
    private String rg;
    @NotBlank
    private MaritalStatus maritalStatus;
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
    @NotBlank
    private String healthInsurance;
    @NotBlank
    private String nationality;
    @NotBlank
    private String profession;
    @NotBlank
    private Address address;

}
