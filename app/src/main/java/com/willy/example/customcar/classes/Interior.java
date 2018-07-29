package com.willy.example.customcar.classes;

import com.willy.example.customcar.enums.AutoPartType;

public class Interior extends AutoPart {

    public Interior(AutoPartType type, String name, String description, int price) {
        super(type, name, description, price);
    }
}
