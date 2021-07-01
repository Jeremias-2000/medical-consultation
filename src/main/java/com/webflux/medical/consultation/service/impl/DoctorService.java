package com.webflux.medical.consultation.service.impl;

import com.webflux.medical.consultation.document.Doctor;
import com.webflux.medical.consultation.dto.DoctorDTO;
import com.webflux.medical.consultation.exception.DoctorNotFoundException;
import com.webflux.medical.consultation.mapper.DoctorMapper;
import com.webflux.medical.consultation.repository.DoctorRepository;
import com.webflux.medical.consultation.service.AbstractDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.webflux.medical.consultation.mapper.DoctorMapper.*;

@Service
public class DoctorService implements AbstractDoctorService<DoctorDTO> {


    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Flux<DoctorDTO> findDoctors() {
        return doctorRepository.findAll()
                .flatMap(DoctorMapper::mapToDTO);
    }



    //@Override
    //public Flux<DoctorDTO> findPatientByMedicalSpeciality(MedicalSpeciality medicalSpeciality) {
      //  return doctorRepository.findPatientByMedicalSpeciality(medicalSpeciality);
    //}

    @Override
    public Mono<DoctorDTO> createDoctor(DoctorDTO dto) {
        return doctorRepository.save(mapToModel(dto))
                .flatMap(DoctorMapper::mapToDTO);

    }

    @Override
    public Mono<DoctorDTO> findDoctorById(String doctorId) {
        return doctorRepository.findById(doctorId)
                .switchIfEmpty(Mono.error(new DoctorNotFoundException(doctorId)))
                .flatMap(DoctorMapper::mapToDTO);

    }

    @Override
    public Mono<DoctorDTO> updateDoctor(String doctorId, DoctorDTO dto) {
         findDoctorById(doctorId)
                .map(r -> mapToModel(dto));
         return Mono.just(dto);
    }

    @Override
    public void deleteDoctorById(String doctorId) {
        doctorRepository.findById(doctorId)
                .switchIfEmpty(Mono.error(new DoctorNotFoundException(doctorId)))
                .flatMap(d -> doctorRepository.deleteById(doctorId));;
    }
}
