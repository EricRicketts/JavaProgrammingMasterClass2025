package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAreaCalculatorNinthExercise {

    double[] testRadii = {2.0, 5.0, -3.0, 0.0};
    double[] expectedCircleAreas = {12.57, 78.54, -1.00, 0.00};
    double[] xArray = {3.56, 4.235, -1.00, 12.987};
    double[] yArray = {-1.00, 10.7864, 4.56, 25.56};
    double[] expectedRectangleAreas = {-1.00, 45.68, -1.00, 331.95};

    @Test
    public void testCalculateCircleArea() {
        for (int index = 0; index < testRadii.length; index += 1) {
            double radius = testRadii[index];
            double expected = expectedCircleAreas[index];
            double result = AreaCalculator.area(radius);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testCalculateRectangleArea() {
        for (int index = 0; index < xArray.length; index += 1) {
            double x = xArray[index];
            double y = yArray[index];
            double expected = expectedRectangleAreas[index];
            double result = AreaCalculator.area(x, y);
            assertEquals(expected, result);
        }
    }
}
