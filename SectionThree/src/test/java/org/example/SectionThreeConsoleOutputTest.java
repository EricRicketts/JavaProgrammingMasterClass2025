package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeConsoleOutputTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testConsoleOutputWithNoLineSeparator() {
        System.out.print("Hello, World!");
        assertEquals("Hello, World!", outputStream.toString());
    }

    @Test
    public void testConsoleOutputWithLineSeparator() {
        System.out.println("Hello, World!");
        String expected = "Hello, World!" + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void testErrorOutputWithNoLineSeparator() {
        System.err.print("Error: check error");
        assertEquals("Error: check error", errorStream.toString());
    }

    @Test
    public void testErrorOutputWithLineSeparator() {
        System.err.println("Error: check error");
        String expected = "Error: check error" + System.lineSeparator();
        assertEquals(expected, errorStream.toString());
    }
}