package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionFiveMethodOverloadingTest {

    String expected, result;

    @Test
    public void testFirstMethodOverloadedMethod() {
        expected = "Player Elmer Fudd scored 10000 points.";
        result = MethodOverloading.calculateScore("Elmer Fudd", 10);
        assertEquals(expected, result);
    }

    @Test
    public void testSecondOverloadedMethod() {
        expected = "Player Unknown Player scored 12000 points.";
        result = MethodOverloading.calculateScore(12);
        assertEquals(expected, result);
    }

    @Test
    public void testThirdOverloadedMethod() {
        expected = "No player name, no player score.";
        result = MethodOverloading.calculateScore();
        assertEquals(expected, result);
    }
}
