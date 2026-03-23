package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCircleAndCylinder {

    private double setScale(double value, int scale) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    Circle circle;
    Cylinder cylinder;

    @BeforeEach
    public void setUp() {
        circle = new Circle(3.75);
        cylinder = new Cylinder(5.55, 7.25);
    }

    @Test
    public void testCircleArea() {
        assertEquals(44.1786, setScale(circle.getArea(), 4));
    }

    @Test
    public void testCircleGetDiameter() {
        assertEquals(23.5619, setScale(circle.getDiameter(), 4));
    }

    @Test
    public void testCylinderSurfaceArea() {
        assertEquals(446.3575, setScale(cylinder.getSurfaceArea(), 4));
    }

    @Test
    public void testCylinderVolume() {
        assertEquals(701.5746, setScale(cylinder.getVolume(), 4));
    }
}
