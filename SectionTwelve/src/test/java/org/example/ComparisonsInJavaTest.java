package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonsInJavaTest {

    @Nested
    @DisplayName("comparisons using compareTo")
    class TestComparisonsUsingCompareTo {

        @Test
        public void testIntegerComparisonsUsingCompareTo() {
            Integer selectedNumber = 5;
            Integer[] numbers = {0, 5, 10, -50, 50};
            Integer[] compareResults = {1, 0, -1, 1, -1};
            for (int index = 0; index< numbers.length; index++) {
                Integer number = numbers[index];
                int result = selectedNumber.compareTo(number);
                assertEquals(result, compareResults[index]);
            }
        }

        @Test
        public void testStringComparisonsUsingCompareTo() {
            String selectedFruit = "banana";
            String[] fruits = {"apple", "banana", "pear", "BANANA"};
            Integer[] compareResults = {1, 0, -14, 32};
            for (int index = 0; index< fruits.length; index++) {
                String fruit = fruits[index];
                int result = selectedFruit.compareTo(fruit);
                assertEquals(result, compareResults[index]);
            }
        }
    }
}
