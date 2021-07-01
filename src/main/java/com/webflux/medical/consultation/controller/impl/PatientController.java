package com.webflux.medical.consultation.controller.impl;


import com.webflux.medical.consultation.controller.AbstractPatientController;
import com.webflux.medical.consultation.dto.PatientDTO;
import com.webflux.medical.consultation.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController implements AbstractPatientController {

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public ResponseEntity<?> getPatients() {
        return ResponseEntity.ok(patientService.findPatients());
    }

    @Override
    public ResponseEntity<?> getPatientById(String patientId) {
        return ResponseEntity.ok(patientService.findPatientById(patientId));
    }

    @Override
    public ResponseEntity<?> createPatient(PatientDTO dto) {
        return new ResponseEntity(patientService.createPatient(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePatient(String patientId) {
        patientService.deleteByPatientId(patientId);
        return ResponseEntity.noContent().build();
    }
}
