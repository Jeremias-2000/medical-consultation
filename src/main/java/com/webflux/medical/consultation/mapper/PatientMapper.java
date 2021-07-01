package com.webflux.medical.consultation.mapper;

import com.webflux.medical.consultation.document.Patient;
import com.webflux.medical.consultation.dto.PatientDTO;
import reactor.core.publisher.Mono;

public class PatientMapper {

    public static Patient mapToModel(PatientDTO dto){
        return Patient.builder()
                .patientId(dto.getPatientId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .gender(dto.getGender())
                .cpf(dto.getCpf())
                .rg(dto.getRg())
                .maritalStatus(dto.getMaritalStatus())
                .birthDay(dto.getBirthDay())
                .healthInsurance(dto.getHealthInsurance())
                .nationality(dto.getNationality())
                .profession(dto.getProfession())
                .address(dto.getAddress())
                .build();
    }

    public static Mono<PatientDTO> mapToDTO(Patient patient){
       PatientDTO dto =  PatientDTO.builder()
                .patientId(patient.getPatientId())
                .fullName(patient.getFullName())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .gender(patient.getGender())
                .cpf(patient.getCpf())
                .rg(patient.getRg())
                .maritalStatus(patient.getMaritalStatus())
                .birthDay(patient.getBirthDay())
                .healthInsurance(patient.getHealthInsurance())
                .nationality(patient.getNationality())
                .profession(patient.getProfession())
                .address(patient.getAddress())
                .build();

      return Mono.just(dto);
    }
}
