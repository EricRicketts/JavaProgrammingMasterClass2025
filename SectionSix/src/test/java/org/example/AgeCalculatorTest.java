package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/*
    Stackoverflow article on how to read from System.out
    https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
*/
public class AgeCalculatorTest {
    public static final String NAME = "Name: ";

    public static String readName() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return NAME.concat(input);
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    String expected, result;
    Integer resultInt;
    Double resultDouble;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
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
    public void testStackOverflowCode() {
        // below is a test taken from Stack Overflow article
        // Test below extends this concept to the class and methods I created
        expected = "hello";
        System.out.print(expected);
        result = outContent.toString();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAgeCalculatorInteger() {
        expected = "30";
        System.out.print(expected);
        resultInt = AgeCalculator.getAgeInteger("2000", "1970");
        result = String.valueOf(resultInt);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAgeCalculatorDouble() {
        expected = "10.5";
        System.out.print(expected);
        resultDouble = AgeCalculator.getAgeDouble("2000", "1989.5");
        result = String.valueOf(resultDouble);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAssertOnInput() {
        expected = "Baeldung";
        provideInput("Baeldung");
        String result = readName();
        Assertions.assertEquals(NAME.concat("Baeldung"), result);
    }

    @Test
    public void testAssertOnOutput() {
        expected = "Baeldung";
        System.out.print("Baeldung");
        result = outContent.toString();
        Assertions.assertEquals(expected, result);
    }
}