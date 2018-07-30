package com.willy.example.customcar.classes;

import java.util.ArrayList;
import java.util.List;

public class CustomizationSession {

    // region singleton definition

    private static CustomizationSession INSTANCE = new CustomizationSession();

    public static CustomizationSession getInstance() {
        return INSTANCE;
    }

    // endregion

    private List<AutoPart> autoParts = new ArrayList<>();

    public void stackPart(AutoPart part) {
        autoParts.add(part);
    }

    public List<AutoPart> getAutoParts() {
        return autoParts;
    }

    public void reset() {
        autoParts = new ArrayList<>();
    }

}
