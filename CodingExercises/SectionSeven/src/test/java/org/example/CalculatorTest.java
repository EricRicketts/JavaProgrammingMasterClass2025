package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Floor firstFloor, secondFloor;
    Carpet firstCarpet, secondCarpet;
    Calculator calculator;
    double expected, result;

    @BeforeEach
    public void setUp() {
        firstFloor = new Floor(2.75, 4.34);
        firstCarpet = new Carpet(3.5);
        secondFloor = new Floor(5.4, 4.5);
        secondCarpet = new Carpet(1.5);
    }

    @Test
    public void testFirstCalculator() {
        expected = 41.7725;
        calculator = new Calculator(firstFloor, firstCarpet);
        result = ScaleOutput.setScaleTo(calculator.getTotalCost(), 4);
        assertEquals(expected, result);
    }

    @Test
    public void testSecondCalculator() {
        expected = 36.45;
        calculator = new Calculator(secondFloor, secondCarpet);
        result = ScaleOutput.setScaleTo(calculator.getTotalCost(), 2);
        assertEquals(expected, result);
    }
}
