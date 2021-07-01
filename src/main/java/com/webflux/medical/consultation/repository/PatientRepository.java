package com.webflux.medical.consultation.repository;

import com.webflux.medical.consultation.document.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PatientRepository extends ReactiveMongoRepository<Patient,String> {
    Mono<Patient> findPatientByFullName(String fullName);
}
