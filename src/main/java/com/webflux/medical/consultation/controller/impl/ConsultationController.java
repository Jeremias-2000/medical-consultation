package com.webflux.medical.consultation.controller.impl;


import com.webflux.medical.consultation.controller.AbstractConsultationController;
import com.webflux.medical.consultation.dto.ConsultationDTO;
import com.webflux.medical.consultation.service.impl.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medical/consultation")
public class ConsultationController implements AbstractConsultationController {

    @Autowired
    private ConsultationService consultationService;


    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Override
    public ResponseEntity<?> findConsultations() {
        return ResponseEntity.ok(consultationService.findMedicalConsultations());
    }

    @Override
    public ResponseEntity<?> findConsultationById(String consultationId) {
        return ResponseEntity.ok(consultationService.findConsultationById(consultationId));
    }

    @Override
    public ResponseEntity<?> createConsultation(ConsultationDTO dto) {
        return new ResponseEntity<>(
                consultationService.createMedicalConsultation(dto), HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<?> updateConsultation(String consultationId, ConsultationDTO dto) {
        return ResponseEntity.ok(consultationService.updateMedicalConsultation(consultationId,dto));
    }

    @Override
    public ResponseEntity<?> deleteConsultation(String consultationId) {
       consultationService.deleteMedicalConsultation(consultationId);
        return ResponseEntity.noContent().build();
    }
}
