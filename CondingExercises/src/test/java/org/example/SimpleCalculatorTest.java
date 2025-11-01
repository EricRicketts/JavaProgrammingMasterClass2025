package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

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
}
