package com.webflux.medical.consultation.service;

import com.webflux.medical.consultation.document.Patient;
import com.webflux.medical.consultation.dto.PatientDTO;
import com.webflux.medical.consultation.exception.exceptionPerExistingPatient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


public interface AbstractPatientService<P>{

    Flux<P> findPatients();

    Mono<P> findPatientById(String patientId);

    Mono<P> findPatientByFullName(String fullName);
    Mono<P> createPatient(P dto);
    Mono<P> updatePatient(String patientId,P dto);

    void deleteByPatientId(String patientId);
    void checkIfThePatientIsAlreadyRegistered(PatientDTO dto) throws exceptionPerExistingPatient;
    void checkIfThePatientIsEmpty(Optional<PatientDTO> dto);
}
