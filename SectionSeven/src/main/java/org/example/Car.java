package org.example;

public class Car {
    private String make, model, color;
    private int year, doors;
    private boolean isConvertible;

    public Car() {
    }

    public String describeCar() {
        return String.format(
                "make: %s model: %s color: %s year: %d doors: %d %s",
                this.getMake(), this.getModel(), this.getColor(),
                this.getYear(), this.getDoors(),
                this.isConvertible() ? "Convertible" : "Not Convertible"
        );
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
