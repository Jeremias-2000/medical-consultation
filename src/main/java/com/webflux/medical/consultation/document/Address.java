package com.webflux.medical.consultation.document;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class Address {

    @NotBlank
    @Size(min = 8,max = 10)
    private String cep; // or zip code
    @NotBlank
    private String city;
    @NotBlank
    @Size(min = 2,max = 45)
    private String state;
    @NotBlank
    private String streetAddress;
    @NotBlank
    private String district;
}
