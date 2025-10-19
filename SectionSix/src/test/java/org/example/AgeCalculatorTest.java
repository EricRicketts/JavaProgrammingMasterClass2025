package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AgeCalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCalculateAgeInteger() {
        int expected = 25;
        int results = AgeCalculator.getAgeInteger("2025", "2000");

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAgeDouble() {
        double expected = 20.4;
        double results = Math.floor(AgeCalculator.getAgeDouble("2025.2", "2004.8") * 10) / 10;

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAgeString() {
        String expected = "hello";
        System.out.print(expected);
        String result = outContent.toString();
        Assertions.assertEquals(expected, result);
    }
}
