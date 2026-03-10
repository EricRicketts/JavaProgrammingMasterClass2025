package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfQuotientsOfDivisorsThreeAndFiveTest {

    @Test
    public void testSumAndQuotients() {
        ArrayList<Integer> result =
                new ArrayList<>(SumQuotientsOfDivisorsThreeAndFive.sumQuotients());
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(15, 30, 45, 60, 75, 225));
        assertEquals(expected, result);
        }
    }
