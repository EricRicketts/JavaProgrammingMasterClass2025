package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPositiveNegativeZero {

    @Test
    public void testPositiveNegativeZero() {
        int[] numbers = {1, -1, 0};
        String[] expected = new String[] {"positive", "negative", "zero"};
        String message;
        for (int index = 0; index < numbers.length; index +=1) {
            int number = numbers[index];
            message = PositiveNegativeZero.checkNumber(number);
            assertEquals(expected[index], message);
        }
    }
}
