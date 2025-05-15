package com.deusley.picpay.enums;

public enum TypeEnum {

    USER(0L, "USER"),
    MERCHANT(1L, "MERCHANT");

    private final String description;

    TypeEnum(long l, String description) {
        this.description = description;
    }

}
