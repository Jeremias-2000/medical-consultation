package com.webflux.medical.consultation.controller;

import com.webflux.medical.consultation.dto.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AbstractPatientController {

    @GetMapping("/all")
    ResponseEntity<?> getPatients();

    @GetMapping("/{id}")
    ResponseEntity<?> getPatientById(@PathVariable("id") String patientId);





    @PostMapping("/create")
    ResponseEntity<?> createPatient(@RequestBody PatientDTO dto);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deletePatient(@PathVariable String patientId);

}
