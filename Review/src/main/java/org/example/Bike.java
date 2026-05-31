package org.example;

import java.math.BigDecimal;

public class Bike extends Vehicle {

    private boolean hasBell;

    public boolean getHasBell() {
        return hasBell;
    }

    public void setHasBell(boolean hasBell) {
        this.hasBell = hasBell;
    }

    public Bike() {
        super("Unknown", new BigDecimal("0.00"));
        this.hasBell = false;
    }

    public Bike(String brand) {
        super(brand, new BigDecimal("0.00"));
        this.hasBell = false;
    }

    public Bike(String brand, BigDecimal speed) {
        super(brand, speed);
        this.hasBell = false;
    }

    public Bike(String brand, BigDecimal speed, boolean hasBell) {
        super(brand, speed);
        this.hasBell = hasBell;
    }
}
