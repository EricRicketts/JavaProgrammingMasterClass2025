package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PickThreePrimeNumbersTest {

    Integer[] expectedNumbers, selectedPrimeNumbers;

    @Test
    public void testForThreePrimeNumbersStartingAtFiveHundred() {
       selectedPrimeNumbers = PrimeNumber.selectThreePrimeNumbers(500);
       expectedNumbers = new Integer[]{503, 509, 521};
       assertArrayEquals(expectedNumbers, selectedPrimeNumbers);
    }

    @Test
    public void testForThreePrimeNumbersStartingAtTwoHundred() {
        selectedPrimeNumbers = PrimeNumber.selectThreePrimeNumbers(200);
        expectedNumbers = new Integer[]{211, 223, 227};
        assertArrayEquals(expectedNumbers, selectedPrimeNumbers);
    }

    @Test
    public void testForThreePrimeNumbersStartingAtNineHundredAndNinety() {
        selectedPrimeNumbers = PrimeNumber.selectThreePrimeNumbers(990);
        expectedNumbers = new Integer[]{991, 997};
        assertArrayEquals(expectedNumbers, selectedPrimeNumbers);
    }
}
