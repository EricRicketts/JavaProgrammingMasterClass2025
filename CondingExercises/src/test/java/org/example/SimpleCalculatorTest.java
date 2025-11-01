package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

    double result;
    SimpleCalculator simpleCalculator;

    @BeforeEach
    public void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void setAndGetFirstNumberTest() {
        simpleCalculator.setFirstNumber(45.67);
        Assertions.assertEquals(45.67, simpleCalculator.getFirstNumber());
    }

    @Test
    public void setAndGetSecondNumberTest() {
        simpleCalculator.setSecondNumber(100.83);
        Assertions.assertEquals(100.83, simpleCalculator.getSecondNumber());
    }

    @Test
    public void getAdditionResultTest() {
        simpleCalculator.setFirstNumber(45.67);
        simpleCalculator.setSecondNumber(100.33);
        Assertions.assertEquals(146.00, simpleCalculator.getAdditionResult());
    }

    @Test
    public void getSubtractionResultTest() {
        simpleCalculator.setFirstNumber(98.23);
        simpleCalculator.setSecondNumber(78.38);
        result = Math.floor(simpleCalculator.getSubtractionResult() * 100) / 100;
        Assertions.assertEquals(19.85, result);
    }

    @Test
    public void getMultiplicationResultTest() {
        simpleCalculator.setFirstNumber(13.89);
        simpleCalculator.setSecondNumber(22.53);
        result = Math.floor(simpleCalculator.getMultiplicationResult() * 100) / 100;
        Assertions.assertEquals(312.94, result);
    }

    @Test
    public void getDivisionResultDivideByZeroTest() {
        simpleCalculator.setFirstNumber(57.55);
        simpleCalculator.setSecondNumber(0);
        Assertions.assertEquals(0, simpleCalculator.getDivisionResult());
    }

    @Test
    public void getDivisionResult() {
        simpleCalculator.setFirstNumber(113.67);
        simpleCalculator.setSecondNumber(18.13);
        result = (double) Math.round(simpleCalculator.getDivisionResult() * 100) / 100;
        Assertions.assertEquals(6.27, result);
    }
}
