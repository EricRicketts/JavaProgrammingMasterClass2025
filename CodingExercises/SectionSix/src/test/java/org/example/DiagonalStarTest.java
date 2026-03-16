package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalStarTest {

    @Test
    public void testDiagonalStarNumberFive() {
        String expected ="*****\n** **\n* * *\n** **\n*****\n";
        String result = DiagonalStar.printSquareStar(5);
        assertEquals(expected, result);
    }
}
