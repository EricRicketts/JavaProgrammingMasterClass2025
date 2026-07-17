package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigTest {

    private Pig pig;
    private String expected, result;

    @BeforeEach
    public void setUp() {
        pig = new Pig();
    }

    @Nested
    @DisplayName("test pig moves")
    class TestPigMoves {

        @Test
        public void testPigMoves() {
            expected = "Pig moves on its stubby little legs.";
            result = pig.move();

            assertEquals(expected, result);
        }
    }

}
