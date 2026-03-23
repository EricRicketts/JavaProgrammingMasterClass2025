package org.example;

public class Circle {

    private final double radius;

    public Circle(double radius) {
        this.radius = (radius < 0) ? 0 : radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI ;
    }

    public double getDiameter() {
        return 2 * this.getRadius() * Math.PI;
    }

    public double getRadius() {
        return radius;
    }
}
