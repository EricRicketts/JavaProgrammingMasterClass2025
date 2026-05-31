package org.example;

import java.math.BigDecimal;

public class Car extends Vehicle {

    private static final String NOT_ENOUGH_DOORS =
        "Car must have at least one door";

    private final int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public Car() {
        super();
        this.numberOfDoors = 2;
    }

    public Car(int numberOfDoors) {
        super();
        this.numberOfDoors = validateNumberOfDoors(numberOfDoors);
    }

    public Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = validateNumberOfDoors(numberOfDoors);
    }

    public Car(String brand, BigDecimal speed, int numberOfDoors) {
        super(brand, speed);
        this.numberOfDoors = validateNumberOfDoors(numberOfDoors);
    }

    private int validateNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_DOORS);
        } else {
            return numberOfDoors;
        }
    }
}
