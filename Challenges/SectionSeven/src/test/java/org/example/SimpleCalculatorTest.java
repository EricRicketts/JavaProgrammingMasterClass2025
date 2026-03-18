package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Test
    public void testSubtractingSecondNumberFromFirstNumber() {
        expected = -23.76;
        BigDecimal bd = new BigDecimal(calculator.getSubtractionResult());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double result = bd.doubleValue();
        assertEquals(expected, result);
    }

    @Test
    public void testMultiplyingFirstAndSecondNumbers() {
        expected = 1923.6592;
        result = calculator.getMultiplicationResult();
        assertEquals(expected, result);
    }

    @Test
    public void testDivideTheFirstNumberByTheSecondNumber() {
        expected = 0.5855;
        BigDecimal bd = new BigDecimal(calculator.getDivisionResult());
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        double result = bd.doubleValue();
        assertEquals(expected, result);
    }

}
