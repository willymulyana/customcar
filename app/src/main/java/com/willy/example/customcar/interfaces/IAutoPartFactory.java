package com.willy.example.customcar.interfaces;

import com.willy.example.customcar.enums.AutoPartType;

public interface IAutoPartFactory {
    IAutoPart getAutoPart(AutoPartType type, String name, String description, Number price);
}
