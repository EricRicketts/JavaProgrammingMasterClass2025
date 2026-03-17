package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseStringTest {

    @Test
    public void testDateOfBirthInteger() {
        String result = ParseString.dateOfBirthInteger();
        String expected = "Age = 23";
        assertEquals(expected, result);
    }

    @Test
    public void testDateOfBirthDouble() {
        String result = ParseString.dateOfBirthDouble();
        String expected = "Result = 10.09";
        assertEquals(expected, result);
    }
}
