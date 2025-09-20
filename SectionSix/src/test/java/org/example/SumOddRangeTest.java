package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOddRangeTest {

    @Test
    public void testSumOddRange() {
        int[] startValues = new int[]{1, -1, 100, 13, 100, 100};
        int[] endValues = new int[]{100, 100, 100, 13, -100, 1000};
        int[] expectedSum = new int[]{2500, -1, 0, 13, -1, 247_500};

        for (int i = 0; i < endValues.length; i++) {
           int start =  startValues[i];
           int end = endValues[i];
           int expected = expectedSum[i];
           int result = SumOddRange.sumOdd(start, end);

            Assertions.assertEquals(expected, result);
        }
    }
}
