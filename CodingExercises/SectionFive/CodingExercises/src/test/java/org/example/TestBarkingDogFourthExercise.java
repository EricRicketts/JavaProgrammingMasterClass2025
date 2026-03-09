package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBarkingDogFourthExercise {

    int[] hourOfDayArray = {1, 2, 8, -1, 22, 0, 23, 24};
    boolean[] barkingArray = {true, false, true, true, true, true, true, true};
    boolean[] expectedArray = {true, false, false, false, false, true, true, false};

    @Test
    public void testBarkingDogFourthExercise() {
        for (int index = 0; index < hourOfDayArray.length; index += 1) {
            int hourOfDay = hourOfDayArray[index];
            boolean barking = barkingArray[index];
            boolean expected = expectedArray[index];
            boolean result = BarkingDog.shouldWakeUp(barking, hourOfDay);
            assertEquals(expected, result);
        }
    }
}
