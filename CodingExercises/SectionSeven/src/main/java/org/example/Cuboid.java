package org.example;

public class Cuboid extends Rectangle  {

    private final double width = 0;
    private final double length = 0;
    private final double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = (height < 0) ? 0 : height;
    }

    public double getVolume() {
        return this.getArea() * this.getHeight();
    }

    public double getHeight() {
        return height;
    }
}
