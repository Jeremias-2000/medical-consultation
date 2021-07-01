package com.webflux.medical.consultation.service.impl;

import com.webflux.medical.consultation.dto.ConsultationDTO;
import com.webflux.medical.consultation.exception.ConsultationNotFoundException;
import com.webflux.medical.consultation.mapper.ConsultationMapper;
import com.webflux.medical.consultation.mapper.PatientMapper;
import com.webflux.medical.consultation.repository.ConsultationRepository;
import com.webflux.medical.consultation.service.AbstractConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsultationService implements AbstractConsultationService<ConsultationDTO> {

    @Autowired
    private ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Flux<ConsultationDTO> findMedicalConsultations() {
        return consultationRepository.findAll()
                .flatMap(ConsultationMapper::mapToDTO);
    }

    @Override
    public Mono<ConsultationDTO> findConsultationById(String consultationId) {
        return consultationRepository.findById(consultationId)
                .flatMap(ConsultationMapper::mapToDTO)
                .switchIfEmpty(Mono.error(new ConsultationNotFoundException(consultationId)));
    }

    @Override
    public Mono<ConsultationDTO> createMedicalConsultation(ConsultationDTO dto) {
        return consultationRepository.save(ConsultationMapper.mapToModel(dto))
                .flatMap(ConsultationMapper::mapToDTO);
    }

    @Override
    public Mono<ConsultationDTO> updateMedicalConsultation(String consultationId, ConsultationDTO dto) {
         findConsultationById(consultationId)
                .map(u -> ConsultationMapper.mapToModel(dto));
         return Mono.just(dto);
    }

    @Override
    public void deleteMedicalConsultation(String consultationId) {
        findConsultationById(consultationId)
                .flatMap(d -> consultationRepository.deleteById(consultationId));
    }
}
