package com.webflux.medical.consultation.controller;


import com.webflux.medical.consultation.dto.ConsultationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AbstractConsultationController {

    @GetMapping("/all")
    ResponseEntity<?> findConsultations();

    @GetMapping("/find/{id}")
    ResponseEntity<?> findConsultationById(@PathVariable("id") String consultationId);

    @PostMapping("/save")
    ResponseEntity<?> createConsultation(@RequestBody ConsultationDTO dto);
    @PutMapping("/update/{id}")
    ResponseEntity<?> updateConsultation(@PathVariable("id")  String consultationId,ConsultationDTO dto);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteConsultation(@PathVariable("id") String consultationId);
}
