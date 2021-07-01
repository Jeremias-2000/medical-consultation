package com.webflux.medical.consultation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum MaritalStatus {
    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    SEPARATED("Separated"),
    WIDOW_ER("Widow_er");

    private final  String status;

    public static MaritalStatus of(String value) {
        return Stream.of(MaritalStatus.values())
                .filter(it -> it.getStatus().equals(value))
                .findFirst()
                .orElseThrow();
    }
}
