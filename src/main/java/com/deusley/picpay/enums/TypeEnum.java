package com.deusley.picpay.enums;

public enum TypeEnum {

    USER(1L, "USER"),
    MERCHANT(2L, "MERCHANT");

    private final String description;

    TypeEnum(long l, String description) {
        this.description = description;
    }

}
