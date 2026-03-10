package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PrimeNumberTest {

    @Test
    public void isPrimeNumberTest() {
        Integer[] listOfPrimesUnderForty = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        ArrayList<Integer> generatedPrimeNumbers = new ArrayList<>();
        for (int number = 0; number <= 40; number++) {
            if (PrimeNumber.isPrimeNumber(number)) {
                generatedPrimeNumbers.add(number);
            }
        }
        assertArrayEquals(listOfPrimesUnderForty, generatedPrimeNumbers.toArray());
    }
}
