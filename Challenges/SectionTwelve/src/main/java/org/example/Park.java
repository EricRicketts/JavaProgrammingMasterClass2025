package org.example;

import java.math.BigDecimal;

public class Park extends Point {

    private final String name;
    private final String type;

    public Park(String name, String type, BigDecimal x, BigDecimal y, int precision) {
        super(x, y, precision);
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
