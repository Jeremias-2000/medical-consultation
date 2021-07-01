package com.webflux.medical.consultation.repository;

import com.webflux.medical.consultation.document.Doctor;

import com.webflux.medical.consultation.dto.DoctorDTO;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DoctorRepository extends ReactiveMongoRepository<Doctor,String> {
   // Flux<DoctorDTO> findPatientByMedicalSpeciality(MedicalSpeciality medicalSpeciality);
}
