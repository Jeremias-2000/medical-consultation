package com.webflux.medical.consultation.mapper;

import com.webflux.medical.consultation.document.MedicalRecord;
import com.webflux.medical.consultation.dto.MedicalRecordDTO;
import reactor.core.publisher.Mono;

public class MedicalRecordMapper {

    public static MedicalRecord mapToModel(MedicalRecordDTO dto){
        return MedicalRecord.builder()
                .medicalRecordId(dto.getMedicalRecordId())
               .patientId(dto.getPatientId())
                .limitation(dto.getLimitation())
                .allergy(dto.getAllergy())
                .medicalRecordNumber(dto.getMedicalRecordNumber())
                .openingDate(dto.getOpeningDate())
                .build();
    }

    public static Mono<MedicalRecordDTO> mapToDTO(MedicalRecord record){
        MedicalRecordDTO dto = MedicalRecordDTO.builder()
                .medicalRecordId(record.getMedicalRecordId())
                .patientId(record.getPatientId())
                .limitation(record.getLimitation())
                .allergy(record.getAllergy())
                .medicalRecordNumber(record.getMedicalRecordNumber())
                .openingDate(record.getOpeningDate())
                .build();
        return Mono.just(dto);
    }
}
