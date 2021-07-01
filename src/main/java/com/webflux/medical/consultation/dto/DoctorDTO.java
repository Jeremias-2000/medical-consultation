package com.webflux.medical.consultation.dto;

import com.webflux.medical.consultation.document.Address;
import com.webflux.medical.consultation.document.Doctor;
import com.webflux.medical.consultation.enums.Gender;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {


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
    private MedicalSpeciality medicalSpecialty;
    @Size(max = 38)
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    private String contact;
    private Address address;

}
