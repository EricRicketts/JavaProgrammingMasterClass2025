package org.example;

public class AreaCalculator {

    public static int precision = 100_000;

    public static double area (double radius) {
        if (radius < 0) {return -1.0;}

        return Math.floor(Math.PI * radius * radius * precision) / precision ;
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0) {return -1.0;}

        return Math.floor(x * y * precision) / precision ;
    }
}
