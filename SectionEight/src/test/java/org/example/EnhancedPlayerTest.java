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
}
