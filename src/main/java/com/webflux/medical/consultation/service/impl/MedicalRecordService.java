package com.webflux.medical.consultation.service.impl;


import com.webflux.medical.consultation.dto.MedicalRecordDTO;
import com.webflux.medical.consultation.exception.MedicalRecordNotFoundException;
import com.webflux.medical.consultation.mapper.MedicalRecordMapper;
import com.webflux.medical.consultation.repository.MedicalRecordRepository;
import com.webflux.medical.consultation.service.AbstractMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MedicalRecordService implements AbstractMedicalRecordService<MedicalRecordDTO> {

    @Autowired
    private MedicalRecordRepository recordRepository;

    @Override
    public Flux<MedicalRecordDTO> findMedicalRecords() {
        return recordRepository.findAll()
                .flatMap(MedicalRecordMapper::mapToDTO) ;
    }

    @Override
    public Mono<MedicalRecordDTO> findMedicalRecordById(String medicalRecordId) {
        return recordRepository.findById(medicalRecordId)
                .switchIfEmpty(Mono.error(new MedicalRecordNotFoundException(medicalRecordId)))
                .flatMap(MedicalRecordMapper::mapToDTO);
    }

    @Override
    public Mono<MedicalRecordDTO> createMedicalRecord(MedicalRecordDTO dto) {
        return recordRepository.save(MedicalRecordMapper.mapToModel(dto))
                .flatMap(MedicalRecordMapper::mapToDTO);
    }

    @Override
    public Mono<MedicalRecordDTO> updateMedicalRecord(String medicalRecordId, MedicalRecordDTO dto) {
        findMedicalRecordById(medicalRecordId)
                .map(m -> MedicalRecordMapper.mapToModel(dto));
        return Mono.just(dto);
    }

    @Override
    public void deleteMedicalRecordById(String medicalRecordId) {
        recordRepository.findById(medicalRecordId)
               .flatMap(m -> recordRepository.deleteById(medicalRecordId));
    }
}
