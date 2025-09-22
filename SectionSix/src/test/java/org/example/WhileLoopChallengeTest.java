package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhileLoopChallengeTest {

    @Test
    public void testWhileLoopChallenge() {
        List<Integer> expected = Arrays.asList(6, 8, 10, 12, 14, 16, 18, 20);
        int number = 5;
        List<Integer> evenNumbers = new ArrayList<>();
        while (number <= 20) {
            if (WhileLoopChallenge.isEvenNumber(number)) {
                evenNumbers.add(number);
            }
            number++;
        }
        Assertions.assertEquals(expected, evenNumbers);
    }

    @Test
    public void testWhileLoopChallengeTwo() {
        int number = 5;
        List <Integer> expectedEvenNumbers = Arrays.asList(6, 8, 10, 12, 14);
        List <Integer> expectedOddNumbers = Arrays.asList(5, 7, 9, 11, 13);
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        while (number <= 20) {
            if (WhileLoopChallenge.isEvenNumber(number)) {
                evenNumbers.add(number);
                if (evenNumbers.size() >= 5) break;
            }
            if (!WhileLoopChallenge.isEvenNumber(number)) {
                oddNumbers.add(number);
            }
            number++;
        }
        Assertions.assertEquals(expectedEvenNumbers, evenNumbers);
        Assertions.assertEquals(expectedOddNumbers, oddNumbers);
    }
}
