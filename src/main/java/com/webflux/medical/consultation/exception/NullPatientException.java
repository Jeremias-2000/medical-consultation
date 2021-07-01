package com.webflux.medical.consultation.exception;

import com.webflux.medical.consultation.dto.PatientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullPatientException extends RuntimeException {

    public NullPatientException(Optional<PatientDTO> dto) {
        super("patient is empty "+ dto);
    }
}
