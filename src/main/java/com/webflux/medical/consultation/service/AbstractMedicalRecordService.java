package com.webflux.medical.consultation.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbstractMedicalRecordService<MR> {

    Flux<MR> findMedicalRecords();
    Mono<MR> createMedicalRecord(MR dto);
    Mono<MR> findMedicalRecordById(String medicalRecordId);
    Mono<MR> updateMedicalRecord(String medicalRecordId,MR dto);
    void deleteMedicalRecordById(String medicalRecordId);
}
