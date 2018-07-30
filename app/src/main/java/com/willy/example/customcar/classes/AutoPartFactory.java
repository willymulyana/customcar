package com.willy.example.customcar.classes;

import com.willy.example.customcar.enums.AutoPartType;
import com.willy.example.customcar.interfaces.IAutoPartFactory;

public class AutoPartFactory implements IAutoPartFactory {

    @Override
    public AutoPart getAutoPart(AutoPartType type, String name, String description, int price) {
        if (type == AutoPartType.TRANSMISSION) {
            return new TransmissionSystem(type, name, description, price);
        } else if (type == AutoPartType.FUEL_TYPE) {
            return new FuelSystem(type, name, description, price);
        } else if (type == AutoPartType.INTERIOR) {
            return new Interior(type, name, description, price);
        } else if (type == AutoPartType.ACCESSORIES) {
            return new Accessories(type, name, description, price);
        } else if (type == AutoPartType.PAINT) {
            return new Paint(type, name, description, price);
        } else {
            throw new Error("Unrecognize part type");
        }
    }
}
