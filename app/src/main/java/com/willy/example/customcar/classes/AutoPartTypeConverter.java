package com.willy.example.customcar.classes;

import android.arch.persistence.room.TypeConverter;

import com.willy.example.customcar.enums.AutoPartType;

public class AutoPartTypeConverter {

    @TypeConverter
    public static AutoPartType toAutoPartType(int type) {
        if (type == AutoPartType.TRANSMISSION.getCode()) {
            return AutoPartType.TRANSMISSION;
        } else if (type == AutoPartType.FUEL_TYPE.getCode()) {
            return AutoPartType.FUEL_TYPE;
        } else if (type == AutoPartType.INTERIOR.getCode()) {
            return AutoPartType.INTERIOR;
        } else if (type == AutoPartType.ACCESSORIES.getCode()) {
            return AutoPartType.ACCESSORIES;
        } else if (type == AutoPartType.PAINT.getCode()) {
            return AutoPartType.PAINT;
        } else {
            throw new IllegalArgumentException("Could not recognize AutoPartType");
        }
    }

    @TypeConverter
    public static int toInteger(AutoPartType type) {
        return type.getCode();
    }

}
