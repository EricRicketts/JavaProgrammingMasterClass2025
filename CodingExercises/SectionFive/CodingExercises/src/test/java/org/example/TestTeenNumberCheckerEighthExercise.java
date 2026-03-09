package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTeenNumberCheckerEighthExercise {

    int[] firstAgesArray = {9, 23, 22, 13, 5};
    int[] secondAgesArray = {99, 15, 23, 12, 30};
    int[] thirdAgesArray = {19, 42, 34, 20, 6};
    boolean[] expectedArray = {true, true, false, true, false};

    @Test
    public void testTeenNumberChecker() {
        for (int index = 0; index < expectedArray.length; index += 1) {
            int firstAge = firstAgesArray[index];
            int secondAge = secondAgesArray[index];
            int thirdAge = thirdAgesArray[index];
            boolean expected = expectedArray[index];
            boolean result = TeenNumberChecker.hasTeen(firstAge, secondAge, thirdAge);

            assertEquals(expected, result);
        }
    }
}
