package org.example;

public class Car extends Vehicle {

    private static final String NOT_ENOUGH_DOORS =
        "The car must have at least one door";

    private int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = validateNumberOfDoors(numberOfDoors);
    }

    public Car() {
        super();
        this.numberOfDoors = 2;
    }

    private Integer validateNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_DOORS);
        } else {
            return numberOfDoors;
        }
    }
}
