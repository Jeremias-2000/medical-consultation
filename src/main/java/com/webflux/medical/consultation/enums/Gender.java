package com.webflux.medical.consultation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Gender {
    MASCULINE("Masculine"),
    FEMININE("Feminine"),
    OTHERS("Others");


    private final String gender;

    public static Gender ofGender(String value) {
        return Stream.of(Gender.values())
                .filter(it -> it.getGender().equals(value))
                .findFirst()
                .orElseThrow();
    }

}


