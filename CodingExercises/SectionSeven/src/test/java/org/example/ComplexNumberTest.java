package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexNumberTest {

    ComplexNumber first, second;
    double resultantImaginary, resultantReal, expectedImaginary, expectedReal;

    @BeforeEach
    public void setUp() {
        first = new ComplexNumber(3.45, 7.82);
        second = new ComplexNumber(4.56, 9.89);
    }

    @Test
    public void testAddRealAndImaginaryComponentsToAComplexNumber() {
        first.add(2.54, 6.34);
        expectedReal = 5.99;
        expectedImaginary = 14.16;
        resultantReal = first.getReal();
        resultantImaginary = first.getImaginary();
        assertEquals(expectedReal, resultantReal);
        assertEquals(expectedImaginary, resultantImaginary);
    }

    @Test
    public void testAddComplexNumberToAComplexNumber() {
        first.add(second);
        expectedReal = 8.01;
        expectedImaginary = 17.71;
        resultantReal = first.getReal();
        resultantImaginary = first.getImaginary();
        assertEquals(expectedReal, resultantReal);
        assertEquals(expectedImaginary, resultantImaginary);
    }

    @Test
    public void testSubtractRealAndImaginaryComponentFromAComplexNumber() {
        first.subtract(8.49, 3.27);
        expectedReal = -5.04;
        expectedImaginary = 4.55;
        resultantReal = ScaleOutput.setScaleTo(first.getReal(), 2);
        resultantImaginary = ScaleOutput.setScaleTo(first.getImaginary(), 2);
        assertEquals(expectedReal, resultantReal);
        assertEquals(expectedImaginary, resultantImaginary);
    }

    @Test
    public void testSubtractAComplexNumberFromAComplexNumber() {
        second.subtract(first);
        expectedReal = 1.11;
        expectedImaginary = 2.07;
        resultantReal = ScaleOutput.setScaleTo(second.getReal(), 2);
        resultantImaginary = ScaleOutput.setScaleTo(second.getImaginary(), 2);
        assertEquals(expectedReal, resultantReal);
        assertEquals(expectedImaginary, resultantImaginary);
    }
}
