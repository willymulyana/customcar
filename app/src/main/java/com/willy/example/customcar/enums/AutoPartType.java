package com.willy.example.customcar.enums;

public enum AutoPartType {

    TRANSMISSION(0),
    FUEL_TYPE(1),
    INTERIOR(2),
    ACCESSORIES(3),
    PAINT(4);

    private int code;

    AutoPartType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
