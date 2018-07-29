package com.willy.example.customcar.interfaces;

import com.willy.example.customcar.enums.AutoPartType;

public interface IAutoPart {

    AutoPartType getType();
    String getName();
    String getDescription();
    int getPrice();

}
