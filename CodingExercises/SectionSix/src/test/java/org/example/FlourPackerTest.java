package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FlourPackerTest {

    @Test
    public void testNegativeParameters() {
        assertFalse(FlourPacker.canPack(-1, 0, 4));
        assertFalse(FlourPacker.canPack(1, -1, 4));
        assertFalse(FlourPacker.canPack(2, 3, -1));
    }

    @Test
    public void testGoalBiggerThanSumOfBigAndSmallKilos() {
        // 2 * 5 = 10 for the big bag, 3 for the small bag total 13
        // which is less than goal of 14
        assertFalse(FlourPacker.canPack(2, 3, 14));
    }

    @Test
    public void testFlourPacker() {
        int[] bigCounts = {1, 1, 0, 2, 3, 2};
        int[] smallCounts = {0, 0, 5, 2, 4, 1};
        int[] goalCounts = {4, 5, 4, 11, 18, 4};
        boolean[] expectedFlourPackerResults = {false, true, true, true, true, false};

        for (int i = 0; i < goalCounts.length; i++) {
            int bigCount = bigCounts[i];
            int smallCount = smallCounts[i];
            int goalCount = goalCounts[i];
            boolean expected = expectedFlourPackerResults[i];

            boolean result = FlourPacker.canPack(bigCount, smallCount, goalCount);
            assertEquals(expected, result);
        }
    }
}
