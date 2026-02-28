package org.example;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeConsoleOutputTest {
    // we declare the output and error streams as ByteArrayOutputStreams to capture the output
    // and make it easier to test
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

    // Capture the original output and error streams in a variable so which can switch back after the test
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUp() {
        // in the setup switch to the output streams
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }

    @AfterAll
    public static void restoreSystemOut() {
        // After each test restore the original output streams
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // Note at the end of each test we have to clear the output and error streams, otherwise we will have
    // leftover data from previous tests we have to do this because the output and error streams are static
    // my desire was not to run @Before and @After after each test but to run them once before all the tests
    // and once after all the tests

    @Test
    public void testConsoleOutputWithNoLineSeparator() {
        System.out.print("Hello, World!");
        assertEquals("Hello, World!", outputStream.toString());
        outputStream.reset();
    }

    @Test
    public void testConsoleOutputWithLineSeparator() {
        System.out.println("Hello, World!");
        String expected = "Hello, World!" + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
        outputStream.reset();
    }

    @Test
    public void testErrorOutputWithNoLineSeparator() {
        System.err.print("Error: check error");
        assertEquals("Error: check error", errorStream.toString());
        errorStream.reset();
    }

    @Test
    public void testErrorOutputWithLineSeparator() {
        System.err.println("Error: check error");
        String expected = "Error: check error" + System.lineSeparator();
        assertEquals(expected, errorStream.toString());
        errorStream.reset();
    }
}