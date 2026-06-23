package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnhancedPlayerTest {

    EnhancedPlayer enhancedPlayer;
    EnhancedPlayer defaultEnhancedPlayer;

    @BeforeEach
    public void setUp() {
        enhancedPlayer = new EnhancedPlayer("Elmer Fudd", 95, "Axe");
        defaultEnhancedPlayer = new EnhancedPlayer();
    }


    @Nested
    @DisplayName("test Enhanced Player constructors")
    class TestEnhancedPlayerConstructors {

        @Test
        public void testThreeArgumentConstructorGetPlayerName() {
            assertEquals("Elmer Fudd", enhancedPlayer.getFullName());
        }

        @Test
        public void testThreeArgumentConstructorGetHealth() {
            assertEquals(95, enhancedPlayer.healthRemaining());
        }

        @Test
        public void testThreeArgumentConstructorGetWeapon() {
            assertEquals("Axe", enhancedPlayer.getWeapon());
        }

        @Test
        public void testNoArgumentConstructorGetPlayerName() {
            assertEquals("John Doe", defaultEnhancedPlayer.getFullName());
        }

        @Test
        public void testNoArgumentConstructorGetHealth() {
            assertEquals(100, defaultEnhancedPlayer.healthRemaining());
        }

        @Test
        public void testNoArgumentConstructorGetWeapon() {
            assertEquals("Sword", defaultEnhancedPlayer.getWeapon());
        }
    }

    @Nested
    @DisplayName("test enhanced player constructor rejects out of bounds health")
    class TestEnhancedPlayerConstructorRejectsOutOfBoundsHealthRatings {

        @Test
        public void testEnhancedPlayerConstructorRejectsZeroHealthRating() {
            enhancedPlayer = new EnhancedPlayer("Elmer Fudd", 0, "Spear");
            assertEquals(-1, enhancedPlayer.healthRemaining());
        }

        @Test
        public void testEnhancedPlayerConstructorRejectsNegativeHealthRating() {
            enhancedPlayer = new EnhancedPlayer("Elmer Fudd", -100, "Spear");
            assertEquals(-1, enhancedPlayer.healthRemaining());
        }

        @Test
        public void testEnhancedPlayerConstructorHealthRatingTooHigh() {
            enhancedPlayer = new EnhancedPlayer("Elmer Fudd", 101, "Spear");
            assertEquals(100, enhancedPlayer.healthRemaining());
        }
    }

    @Nested
    @DisplayName("test enhanced player loses health")
    class TestEnhancedPlayerLosesHealth {

        @Test
        public void testEnhancedPlayerLosesHealthButCanRemainInGame() {
            String result = enhancedPlayer.looseHealth(50);
            String expected = "The player's health is sufficient to remain in the game.";

            assertEquals(45, enhancedPlayer.healthRemaining());
            assertEquals(expected, result);
        }

        @Test
        public void testEnhancedPlayerLosesHealthResultingInRemovalFromGame() {
            String result = enhancedPlayer.looseHealth(100);
            String expected = "The player's health has caused his removal from the game.";

            assertEquals(-5, enhancedPlayer.healthRemaining());
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test enhanced player restore health")
    class TestEnhancedPlayerRestoreHealth {

        @Test
        public void testEnhancedPlayerRestoreHealthCappedAtOneHundred() {
            assertEquals(95, enhancedPlayer.healthRemaining());
            enhancedPlayer.restoreHealth(105);

            assertEquals(100, enhancedPlayer.healthRemaining());
        }

        @Test
        public void testEnhancedPlayerRestoreHealthUnderOneHundred() {
            assertEquals(95, enhancedPlayer.healthRemaining());
            enhancedPlayer.looseHealth(55);

            assertEquals(40, enhancedPlayer.healthRemaining());
            enhancedPlayer.restoreHealth(30);

            assertEquals(70, enhancedPlayer.healthRemaining());
        }
    }
}
