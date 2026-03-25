package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {

    Printer duplexPrinter, nonDuplexPrinter;
    private int[] expected, results;

    @BeforeEach
    public void setUp() {
        nonDuplexPrinter = new Printer(100, false);
        duplexPrinter = new Printer(100, true);
    }

    @Test
    public void testTonerLevelOnDuplexPrinter() {
        int[] invalidTonerLevels = new int[]{-110, 100};
        int[] expectedResults = new int[]{-1, -1};
        int[] results = new int[]{
                duplexPrinter.addToner(invalidTonerLevels[0]),
                duplexPrinter.addToner(invalidTonerLevels[1]),
        };
        assertArrayEquals(expectedResults, results);
    }

    @Test
    public void testSubtractAndAddTonerLevelToNonDuplexPrinter() {
        int expected = 60;
        nonDuplexPrinter.setTonerLevel(40);
        nonDuplexPrinter.addToner(20);
        assertEquals(expected, nonDuplexPrinter.getTonerLevel());
    }

    @Test
    public void testPagesPrintedNonDuplexPrinter() {
        expected = new int[]{10, 11};
        results = new int[]{
            nonDuplexPrinter.printPages(10),
            nonDuplexPrinter.printPages(11)
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testPagesPrintedDuplexPrinter() {
        expected = new int[]{5, 6};
        results = new int[]{
            duplexPrinter.printPages(10),
            duplexPrinter.printPages(11)
        };
        assertArrayEquals(expected, results);
    }
}
