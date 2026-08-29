package org.example;

import java.math.BigDecimal;

public class ParkTwo extends PointTwo {

    private final String name;
    private final String type;

    public ParkTwo(String name, String type, BigDecimal x, BigDecimal y, int scaleFactor) {
        super(x, y, scaleFactor);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") " + super.toString();
    }
}
