package com.webflux.medical.consultation.controller;

import com.webflux.medical.consultation.dto.DoctorDTO;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AbstractDoctorController {

    @GetMapping("/all")
    ResponseEntity<?> findDoctors();

    @GetMapping("/find/{id}")
    ResponseEntity<?> findDoctorById(@PathVariable("id") String doctorId);

   // @GetMapping("/find/{speciality}")
    //ResponseEntity<?> findByMedicalSpeciality(@PathVariable("speciality") MedicalSpeciality medicalSpeciality);

    @PostMapping("/save")
    ResponseEntity<?> createDoctor(@RequestBody  DoctorDTO dto);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteDoctor(@PathVariable("id") String doctorId);
}
