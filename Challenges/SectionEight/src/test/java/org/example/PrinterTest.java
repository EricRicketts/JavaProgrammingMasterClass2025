package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {

    private double setScale(double value, int scaleFactor) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scaleFactor, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    Printer duplexPrinter, nonDuplexPrinter;
    double expected, result;
    int expectedTonerLevel;

    @BeforeEach
    public void setUp() {
        duplexPrinter = new Printer(100, true);
        nonDuplexPrinter = new Printer(100, false);
    }

    @Test
    public void testDuplexPrinting() {
        expected = 10.00;
        result = duplexPrinter.printPages(20);
        result = setScale(result, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testNonDuplexPrinting() {
        expected = 20.00;
        result = nonDuplexPrinter.printPages(20);
        result = setScale(result, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testGetPagesPrinted() {
        int expectedPages = 20;
        for (int i = 0; i < 2; i++) {
            nonDuplexPrinter.printPages(10);
        }
        assertEquals(expectedPages, nonDuplexPrinter.getPagesPrinted());
    }

    @Test
    public void testRemoveToner() {
        expectedTonerLevel = 60;
        duplexPrinter.addToner(-40);
        assertEquals(expectedTonerLevel, duplexPrinter.getTonerLevel());
    }

    @Test
    public void testAddToner() {
        expectedTonerLevel = 80;
        nonDuplexPrinter.addToner(-40);
        nonDuplexPrinter.addToner(20);
        assertEquals(expectedTonerLevel, nonDuplexPrinter.getTonerLevel());
    }

    @Test
    public void testTonerLevelBelowZero() {
        expectedTonerLevel = -1;
        int result = duplexPrinter.addToner(-110);
        assertEquals(expectedTonerLevel, result);
    }

    @Test
    public void testTonerLevelOverOneHundred() {
        expectedTonerLevel = -1;
        duplexPrinter.addToner(-20);
        result = duplexPrinter.addToner(40);
        assertEquals(expectedTonerLevel, result);
    }

}
