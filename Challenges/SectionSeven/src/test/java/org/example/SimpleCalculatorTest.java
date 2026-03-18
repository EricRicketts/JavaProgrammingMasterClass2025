package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    SimpleCalculator calculator;
    double firstNumber, secondNumber, expected, result;

    @BeforeEach
    public void setUp() {
        calculator = new SimpleCalculator();
        firstNumber = 33.56;
        secondNumber = 57.32;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
    }

    @Test
    public void testSettersAndGettersForFirstAndSecondNumbers() {
        double[] expected = new double[]{firstNumber, secondNumber};
        double[] result = new double[]{
                calculator.getFirstNumber(), calculator.getSecondNumber()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddingFirstAndSecondNumbers() {
        expected = 90.88;
        result = calculator.getAdditionResult();
        assertEquals(expected, result);
    }
}
