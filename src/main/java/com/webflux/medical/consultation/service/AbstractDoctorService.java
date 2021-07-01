package com.webflux.medical.consultation.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbstractDoctorService<D> {

    Flux<D> findDoctors();
    //Flux<D> findPatientByMedicalSpeciality(MedicalSpeciality medicalSpeciality);

    Mono<D> createDoctor(D dto);
    Mono<D> findDoctorById(String doctorId);

   Mono<D> updateDoctor(String doctorId,D dto);
     void deleteDoctorById(String doctorId);
}
