package org.example;

public class Car {
    private String make, model, color;
    private int year, doors;
    private boolean isConvertible;

    public static boolean hasElectricDrive = false;
    private static int numberOfCars; // Initializes to zero.
    // A static variable is shared across all instances, but it is typically
    // called at the class level.

    // I made the no-arguments constructor a Toyota Corolla because this
    // is the most produced car in the world.
    public Car() {
        this("Toyota", "Corolla",
                "Classic Silver Metallic", 2026,
                4, false);
    }

    public Car(String make, String model, String color,
               int year, int doors, boolean isConvertible) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.doors = doors;
        this.isConvertible = isConvertible;
        Car.numberOfCars += 1;
    }

    public String describeCar() {
        return String.format(
                "make: %s model: %s color: %s year: %d doors: %d %s",
                this.getMake(), this.getModel(), this.getColor(),
                this.getYear(), this.getDoors(),
                this.isConvertible() ? "Convertible" : "Not Convertible"
        );
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }
}
