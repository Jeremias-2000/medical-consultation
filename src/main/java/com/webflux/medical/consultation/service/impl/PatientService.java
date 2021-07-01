package com.webflux.medical.consultation.service.impl;

import com.webflux.medical.consultation.document.Patient;
import com.webflux.medical.consultation.dto.PatientDTO;

import com.webflux.medical.consultation.exception.ExceptionByFullNameNotFound;
import com.webflux.medical.consultation.exception.PatientNotFoundException;
import com.webflux.medical.consultation.exception.exceptionPerExistingPatient;
import com.webflux.medical.consultation.exception.NullPatientException;
import com.webflux.medical.consultation.mapper.PatientMapper;
import com.webflux.medical.consultation.repository.PatientRepository;
import com.webflux.medical.consultation.service.AbstractPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static java.util.Optional.*;

@Service
public class PatientService implements AbstractPatientService<PatientDTO> {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Flux<PatientDTO> findPatients() {
        Flux<Patient> patients = patientRepository.findAll();
        return patientRepository.findAll()
                .flatMap(PatientMapper::mapToDTO);
    }


    @Override
    public Mono<PatientDTO> findPatientById(String patientId) {
       return patientRepository.findById(patientId)
               .flatMap(PatientMapper::mapToDTO)
               .switchIfEmpty(Mono.error(new PatientNotFoundException(patientId)));

    }

    @Override
    public Mono<PatientDTO> findPatientByFullName(String fullName) {
        return patientRepository.findPatientByFullName(fullName)
                .flatMap(PatientMapper::mapToDTO)
                .switchIfEmpty(Mono.error(new ExceptionByFullNameNotFound(fullName)));
    }

    @Override
    public Mono<PatientDTO> createPatient(PatientDTO dto) {
        checkIfThePatientIsEmpty(ofNullable(dto));
        checkIfThePatientIsAlreadyRegistered(dto);
       return patientRepository.save(PatientMapper.mapToModel(dto))
               .flatMap(PatientMapper::mapToDTO);

    }

    @Override
    public Mono<PatientDTO> updatePatient(String patientId, PatientDTO dto) {
        findPatientById(patientId)
                .map(p -> PatientMapper.mapToModel(dto));
        return Mono.just(dto);
    }

    @Override
    public void deleteByPatientId(String patientId) {
        findPatientById(patientId)
                .switchIfEmpty(Mono.error(new PatientNotFoundException(patientId)))
                .flatMap(d -> patientRepository.deleteById(patientId));

    }

    @Override
    public void checkIfThePatientIsAlreadyRegistered(PatientDTO dto) throws exceptionPerExistingPatient {
        if (dto.getFullName().equals(patientRepository.findPatientByFullName(dto.getFullName()))){
            throw new exceptionPerExistingPatient("patient already exists " + dto);
        }

    }

    @Override
    public void checkIfThePatientIsEmpty(Optional<PatientDTO> dto) {
        if (!dto.isPresent())
            throw  new NullPatientException(dto);
    }
}
