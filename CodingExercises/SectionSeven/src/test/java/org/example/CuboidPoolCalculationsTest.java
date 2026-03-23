package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuboidPoolCalculationsTest {

    private double setScale(double value, int scaleFactor) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scaleFactor, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    Rectangle rectangle;
    Cuboid cuboid;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(4.68, 7.52);
        cuboid = new Cuboid(3.45, 4.56, 7.89);
    }

    @Test
    public void testRectangleArea() {
        assertEquals(35.1936, setScale(rectangle.getArea(), 4));
    }

    @Test
    public void testCuboidVolume() {
        assertEquals(124.1255, setScale(cuboid.getVolume(), 4));
    }
}
