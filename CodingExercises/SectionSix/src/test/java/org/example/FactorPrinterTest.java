package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorPrinterTest {

    int[] numbers = {6, 32, 10, 117};
    String[] factorArray = {
            "1 2 3 6",
            "1 2 4 8 16 32",
            "1 2 5 10",
            "1 3 9 13 39 117"
    };
    String expected, result;

    @Test
    public void testInvalidValueForFactorPrinter() {
        String expected = "Invalid Value";
        String result = FactorPrinter.printFactors(0);
        assertEquals(expected, result);
    }

    @Test
    public void testFactorPrinter() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String expected = factorArray[i];
            String result = FactorPrinter.printFactors(number);

            assertEquals(expected, result);
        }
    }
}
