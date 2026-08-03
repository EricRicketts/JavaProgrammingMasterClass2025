package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparableTest {

    private Integer five = 5;
    private Integer[] others = {0, 5, 10, -50, 50};
    private Integer[] expected;
    private Integer result;
    private String banana = "banana";
    private String[] fruit = {"apple", "banana", "pear", "BANANA"};


    @Test
    public void testComparableCompareToMethodWithIntegers() {
        expected = new Integer[]{1, 0, -1, 1, -1};
        for (int index = 0; index < others.length; index++) {
            Integer currentNumber = others[index];
            result = five.compareTo(currentNumber);
            Integer expectedCompare = expected[index];

            assertEquals(expectedCompare, result);
        }
    }

    @Test
    public void testComparableCompareToMethodWithStrings() {
        expected = new Integer[]{1, 0, ('b' - 'p'), ('b' - 'B')};
        for (int index = 0; index < fruit.length; index++) {
            String currentFruit = fruit[index];
            Integer result = banana.compareTo(currentFruit);
            Integer expectedCompare = expected[index];

            assertEquals(expectedCompare, result);
        }
    }

}
