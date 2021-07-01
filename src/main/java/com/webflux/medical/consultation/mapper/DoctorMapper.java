package com.webflux.medical.consultation.mapper;

import com.webflux.medical.consultation.document.Doctor;
import com.webflux.medical.consultation.dto.DoctorDTO;
import reactor.core.publisher.Mono;

public class DoctorMapper {


    public static Doctor mapToModel(DoctorDTO dto){
        return Doctor.builder()
                .doctorId(dto.getDoctorId())
                .fullName(dto.getFullName())
                .cpf(dto.getCpf())
                .crm(dto.getCrm()).
                gender(dto.getGender())
                .medicalSpecialty(dto.getMedicalSpecialty())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .contact(dto.getContact())
                .address(dto.getAddress())
                .build();
    }

    public static Mono<DoctorDTO> mapToDTO(Doctor doctor){
        DoctorDTO dto = DoctorDTO.builder()
                .doctorId(doctor.getDoctorId())
                .fullName(doctor.getFullName())
                .cpf(doctor.getCpf())
                .crm(doctor.getCrm())
                .gender(doctor.getGender())
                .medicalSpecialty(doctor.getMedicalSpecialty())
                .email(doctor.getEmail())
                .password(doctor.getPassword())
                .contact(doctor.getContact())
                .address(doctor.getAddress())
                .build();
        return Mono.just(dto);
    }
}
