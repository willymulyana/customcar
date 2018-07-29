package com.willy.example.customcar.classes;

import com.willy.example.customcar.enums.AutoPartType;

public class Paint extends AutoPart {

    public Paint(AutoPartType type, String name, String description, int price) {
        super(type, name, description, price);
    }
}
