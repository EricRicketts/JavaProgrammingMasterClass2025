package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectNumberTest {

    int[] numbers = {6, 10, 28, 204, 496, 5124, 8128};
    boolean[] expectedResults = {true, false, true, false, true, false, true};

    @Test
    public void testPerfectNumber() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean expected = expectedResults[i];
            boolean result = PerfectNumber.isPerfectNumber(number);

            assertEquals(expected, result);
        }
    }
}
