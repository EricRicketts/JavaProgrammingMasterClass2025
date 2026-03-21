package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    private double setPrecision(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    Point first, second;
    double expected, result;

    @BeforeEach
    public void setUp() {
        first = new Point(7, 3);
        second = new Point(-5, 2);
    }

    @Test
    public void testDistanceFromOrigin() {
        expected = 7.6158;
        result = setPrecision(first.distance());
        assertEquals(expected, result);
    }

    @Test
    public void testDistanceFromGivenPoint() {
        expected = 12.0416;
        result = setPrecision(first.distance(second));
        assertEquals(expected, result);
    }

    @Test
    public void testDistanceFromGivenXAndYCoordinates() {
        expected = 16.6433;
        result = setPrecision(second.distance(9, 11));
        assertEquals(expected, result);
    }
}
