package org.example;

public class Car {
    private String make = "Tesla";
    private String model = "Model X";
    private String color = "Gray";
    private int doors = 2;
    private boolean convertible = true;

    public String describeCar() {
        return
            doors
            + "-Door- "
            + color
            + " "
            +  make
            + " "
            + model
            + (convertible ? " (convertible)" : "");
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        // set make it a known value if passed in as null
        if (make == null) { make  = "Unknown"; }
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake) {
            case "holden", "porsche", "tesla" -> this.make = make;
            default -> this.make = "Unsupported";
        }
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

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }
}
