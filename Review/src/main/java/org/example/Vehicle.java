package org.example;

import java.math.BigDecimal;

public class Vehicle {

    private static final String SPEED_TO_LOW =
        "Speed cannot be less than zero.";

    private String brand;
    private BigDecimal speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand, BigDecimal speed) {
        this.brand = brand;
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand) {
        this(brand, new BigDecimal("0.00"));
    }

    public Vehicle() {
        this("Unknown", new BigDecimal("0.00"));
    }

    private BigDecimal validateSpeed(BigDecimal speed) {
        if (speed.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(SPEED_TO_LOW);
        } else {
            return speed;
        }
    }
}
