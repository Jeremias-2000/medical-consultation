package com.webflux.medical.consultation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpecialityNotFoundException extends RuntimeException {
    public SpecialityNotFoundException(String s) {
        super(s);
    }


}
