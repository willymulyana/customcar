package com.willy.example.customcar.interfaces;

import com.willy.example.customcar.classes.AutoPart;
import com.willy.example.customcar.enums.AutoPartType;

public interface IAutoPartFactory {
    AutoPart getAutoPart(AutoPartType type, String name, String description, int price);
}
