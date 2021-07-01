package com.webflux.medical.consultation.mapper;

import com.webflux.medical.consultation.document.Consultation;
import com.webflux.medical.consultation.dto.ConsultationDTO;
import reactor.core.publisher.Mono;

public class ConsultationMapper {

    public static Consultation mapToModel(ConsultationDTO dto){
        return Consultation.builder()
                .consultationId(dto.getConsultationId())
                .patientId(dto.getPatientId())
                .doctorId(dto.getDoctorId())
                .appointmentDate(dto.getAppointmentDate())
                .price(dto.getPrice())
                .build();
    }

    public static Mono<ConsultationDTO> mapToDTO(Consultation consultation){
        ConsultationDTO dto =  ConsultationDTO.builder()
                              .consultationId(consultation.getConsultationId())
                              .patientId(consultation.getPatientId())
                              .doctorId(consultation.getDoctorId())
                              .appointmentDate(consultation.getAppointmentDate())
                              .price(consultation.getPrice())
                              .build();

        return Mono.just(dto);
    }
}
