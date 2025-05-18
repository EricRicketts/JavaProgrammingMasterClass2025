package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to a ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restore the original System.out after each test
        System.setOut(originalOut);
    }

    @Test
    public void testApp() {
        // Call App.main which makes a call to System.out.println
        App.main(null);
        // Capture and verify the output
        String expectedOutput = "Hello World!", actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}
