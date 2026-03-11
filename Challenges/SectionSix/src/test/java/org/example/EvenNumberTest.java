package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenNumberTest {

    /*
        Note this test used a while loop to fulfill the requirements for Lesson #68 a while
        loop challenge
    */
    @Test
    public void testEvenNumbers() {
        int number = 1;
        int finishNumber = 20;
        int totalNumberCount = 0;
        int expectedTotalNumberCount = 10;
        ArrayList<Integer> expectedEvenNumberList =
            new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        while (number <= finishNumber) {
            totalNumberCount++;
            if (EvenNumber.isEvenNumber(number)) {
                evenNumbers.add(number);
            }
            if (evenNumbers.size() == 5) break;
            number += 1;
        }
        assertEquals(expectedEvenNumberList, evenNumbers);
        assertEquals(expectedTotalNumberCount, totalNumberCount);
    }
}
