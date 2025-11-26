package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.PackedColorModel;

public class SimpleCalculatorTest {

    SimpleCalculator simpleCalculator;

    @BeforeEach
    void setUp() {
        simpleCalculator = new SimpleCalculator();
        simpleCalculator.setFirstNumber(143.44);
        simpleCalculator.setSecondNumber(456.37);
    }

    @Test
    public void testGetAndSetFirstNumber() {
        Assertions.assertEquals(143.44, simpleCalculator.getFirstNumber());
    }

    @Test
    public void testGetAndSetSecondNumber() {
        Assertions.assertEquals(456.37, simpleCalculator.getSecondNumber());
    }

    @Test
    public void testGetAdditionResult() {
        double expected = 143.44 +  456.37;
        Assertions.assertEquals(expected, simpleCalculator.getAdditionResult());
    }

    @Test
    public void testGetSubtractionResult() {
        double expected = 143.44 -  456.37;
        Assertions.assertEquals(expected, simpleCalculator.getSubtractionResult());
    }

    @Test
    public void testGetMultiplicationResult() {
        double expected = 143.44 *  456.37;
        Assertions.assertEquals(expected, simpleCalculator.getMultiplicationResult());
    }

    @Test
    public void testGetDivisionResult() {
        double expected = 143.44 /  456.37;
        Assertions.assertEquals(expected, simpleCalculator.getDivisionResult());
    }

}
