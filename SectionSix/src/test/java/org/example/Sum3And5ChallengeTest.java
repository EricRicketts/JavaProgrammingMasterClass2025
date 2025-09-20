package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3And5ChallengeTest {
    int sum = 0;
    List<Integer> divisorList = new ArrayList<>();
    int[] expected = new int[]{15, 30, 45, 60, 75};
    @Test
    public void testSum3And5Challenge() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                divisorList.add(i);
                if (divisorList.size() == 5) break;
            }
        }
        int[] divisors = divisorList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(divisors);
        Assertions.assertArrayEquals(expected, divisors);
    }
}
