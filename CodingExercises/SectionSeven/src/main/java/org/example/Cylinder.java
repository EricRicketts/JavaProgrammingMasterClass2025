package org.example;

public class Cylinder extends Circle {

    private final double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getVolume() {
        return this.getArea() * this.getHeight();
    }

    public double getSurfaceArea() {
        return this.getDiameter() * this.getHeight();
    }

    public double getHeight() {
        return height;
    }
}
