package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntEqualityPrinter {

    @Test
    public void testPrintEqual() {
        assertEquals("All numbers are equal",
                IntEqualityPrinter.printEqual(1, 1, 1));
        assertEquals("All numbers are different",
                IntEqualityPrinter.printEqual(1, 2, 3));
        assertEquals("Neither all are equal or different",
                IntEqualityPrinter.printEqual(1, 2, 2));
        assertEquals("Invalid Value",
                IntEqualityPrinter.printEqual(-1, 5, 7));
    }
}
