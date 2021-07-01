package com.webflux.medical.consultation.controller.impl;

import com.webflux.medical.consultation.controller.AbstractDoctorController;
import com.webflux.medical.consultation.dto.DoctorDTO;
import com.webflux.medical.consultation.enums.MedicalSpeciality;
import com.webflux.medical.consultation.service.impl.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController implements AbstractDoctorController {

    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public ResponseEntity<?> findDoctors() {
        return ResponseEntity.ok(doctorService.findDoctors());
    }

    //@Override
    //public ResponseEntity<?> findByMedicalSpeciality(MedicalSpeciality medicalSpeciality) {
      //  return ResponseEntity.ok(doctorService.findPatientByMedicalSpeciality(medicalSpeciality));
    //}

    @Override
    public ResponseEntity<?> findDoctorById(String doctorId) {
        return ResponseEntity.ok(doctorService.findDoctorById(doctorId));
    }

    @Override
    public ResponseEntity<?> createDoctor(DoctorDTO dto) {
        return new  ResponseEntity<>(doctorService.createDoctor(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteDoctor(String doctorId) {
        doctorService.deleteDoctorById(doctorId);
        return ResponseEntity.ok().build();
    }
}
