package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReadUserInputTest {

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

    public static String readInput(String input) {
        Scanner scanner = new Scanner(System.in);
        String readScanner = scanner.next();
        return input.concat(readScanner);
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testReadFiveValidNumbersNoErrors() {
        ReadUserInput readUserInput = new ReadUserInput();
        for (int index = 0; index < 5; index++) {
            int number = index + 2;
            String expected = String.valueOf(number);
            String numberToString = readUserInput.readValidNumber(number);
            provideInput(numberToString);
            String result  = readInput(""); // want to read the input, so concatenate the scanner results with
            // an empty string
            Assertions.assertEquals(expected, result);
        }
    }
}
