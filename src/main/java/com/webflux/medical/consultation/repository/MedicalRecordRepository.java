package com.webflux.medical.consultation.repository;

import com.webflux.medical.consultation.document.MedicalRecord;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends ReactiveMongoRepository<MedicalRecord,String> {
}
