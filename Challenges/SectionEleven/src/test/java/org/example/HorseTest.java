package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorseTest {

    private Horse horse;

    @BeforeEach
    public void setUp() {
        horse = new Horse("Clydesdale", "Large", 10123.45);
    }

    @Nested
    @DisplayName("test horse overridden methods")
    class TestHorseOverriddenMethods {

        @Test
        public void testHorseMoveMethod() {
            String expected = "Horse (Clydesdale) walks";
            String result = horse.move("slow");

            assertEquals(expected, result);
        }

        @Test
        public void testMakeNoiseMethod() {
            String expected = "Any horse can neigh.";
            String result = horse.makeNoise();

            assertEquals(expected, result);
        }

        @Test
        public void testShedHairMethod() {
            String expected = "A horse sheds hair in the Spring.";
            String result = horse.shedHair();

            assertEquals(expected, result);
        }
    }
}
