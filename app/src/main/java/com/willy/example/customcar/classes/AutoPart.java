package com.willy.example.customcar.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.willy.example.customcar.enums.AutoPartType;
import com.willy.example.customcar.interfaces.IAutoPart;

@Entity
public class AutoPart implements IAutoPart {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @TypeConverters(AutoPartTypeConverter.class)
    private AutoPartType type;

    private String name;
    private String description;
    private int price;

    public AutoPart(AutoPartType type, String name, String description, int price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public AutoPartType getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public static AutoPart[] populateData() {
        return new AutoPart[]{
                new AutoPart(AutoPartType.TRANSMISSION, "Auto", "Automatic Transmission", 1000),
                new AutoPart(AutoPartType.TRANSMISSION, "Manual", "Automatic Transmission", 500),

                new AutoPart(AutoPartType.FUEL_TYPE, "Gas", "Gasoline Fuel", 750),
                new AutoPart(AutoPartType.FUEL_TYPE, "Diesel", "Diesel Fuel", 500),

                new AutoPart(AutoPartType.INTERIOR, "Interior 1", "Interior Type 1", 500),
                new AutoPart(AutoPartType.INTERIOR, "Interior 2", "Interior Type 2", 750),
                new AutoPart(AutoPartType.INTERIOR, "Interior 3", "Interior Type 3", 1000),

                new AutoPart(AutoPartType.ACCESSORIES, "Accessories 1", "Accessories Type 1", 250),
                new AutoPart(AutoPartType.ACCESSORIES, "Accessories 2", "Accessories Type 2", 500),
                new AutoPart(AutoPartType.ACCESSORIES, "Accessories 3", "Accessories Type 3", 750),
                new AutoPart(AutoPartType.ACCESSORIES, "Accessories 4", "Accessories Type 4", 1000),
                new AutoPart(AutoPartType.ACCESSORIES, "Accessories 5", "Accessories Type 5", 1250),

                new AutoPart(AutoPartType.PAINT, "Crimson Red", "Crimson Red Paint", 250),
                new AutoPart(AutoPartType.PAINT, "White", "White Paint", 250),
                new AutoPart(AutoPartType.PAINT, "Silver", "Silver Paint", 250),
                new AutoPart(AutoPartType.PAINT, "Black", "Black Paint", 250),
                new AutoPart(AutoPartType.PAINT, "Gold", "Golden Paint", 275),

        };
    }
}
