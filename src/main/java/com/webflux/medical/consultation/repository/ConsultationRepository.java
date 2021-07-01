package com.webflux.medical.consultation.repository;

import com.webflux.medical.consultation.document.Consultation;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends ReactiveMongoRepository<Consultation,String> {
}
