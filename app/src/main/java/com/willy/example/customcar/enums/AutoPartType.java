package com.willy.example.customcar.enums;

import java.util.HashMap;
import java.util.Map;

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

    private static Map<Integer, AutoPartType> map = new HashMap<>();

    static {
        for (AutoPartType type : AutoPartType.values()) {
            map.put(type.code, type);
        }
    }

    public static AutoPartType valueOf(int typeNo) {
        return map.get(typeNo);
    }
}
