package com.webflux.medical.consultation.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbstractConsultationService<C> {

    Flux<C> findMedicalConsultations();
    Mono<C> findConsultationById(String consultationId);
    Mono<C> createMedicalConsultation(C dto);
    Mono<C> updateMedicalConsultation(String consultationId, C dto);
    void deleteMedicalConsultation(String consultationId);
}
