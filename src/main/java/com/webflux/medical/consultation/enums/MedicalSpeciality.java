package com.webflux.medical.consultation.enums;

import com.webflux.medical.consultation.exception.SpecialityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum MedicalSpeciality {

    //some examples of medical specialties

    ALLERGIST("Allergist"),
    ANESTHESIOLOGIST("Anesthesiologist"),
    CARDIOLOGIST("Cardiologist"),
    DENTIST("Dentist"),
    DERMATOLOGIST("Dermatologist"),
    ENDOCRINOLOGIST("Endocrinologist"),
    GYNAECOLOGIST("Gynaecologist"),
    NEUROLOGIST("Neurologist"),
    OBSTETRICIAN("Obstetrician"),
    OPHTHALMOLOGIST("Ophthalmologist"),
    ONCOLOGIST("Oncologist"),
    ORTHOPEDIST("Orthopedist"),
    PSYCHIATRIST("Psychiatrist"),
    PAEDIATRICIAN("Paediatrician"),
    SURGEON("Surgeon"),
    RADIOLOGIST("Radiologist"),
    UROLOGIST("Urologist");

   private final String speciality;


    public static MedicalSpeciality of(String value) {
        return Stream.of(MedicalSpeciality.values())
                .filter(it -> it.getSpeciality().equals(value))
                .findFirst()
                .orElseThrow();
    }
}
