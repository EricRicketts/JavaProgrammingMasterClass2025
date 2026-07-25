package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Tom Bombadil", 10, 50);
    }

    @Nested
    @DisplayName("test player getters")
    class TestPlayerGetters {

        @Test
        public void testGetPlayerName() {
            assertEquals("Tom Bombadil", player.getName());
        }

        @Test
        public void testGetPlayerHitPoints() {
            assertEquals(10, player.getHitPoints());
        }

        @Test
        public void testGetPlayerStrength() {
            assertEquals(50, player.getStrength());
        }

        @Test
        public void testGetPlayerWeapon() {
            assertEquals("Sword", player.getWeapon());
        }
    }

    @Nested
    @DisplayName("test player setters")
    class TestPlayerSetters {

        @Test
        public void testSetPlayerName() {
            assertEquals("Tom Bombadil", player.getName());

            player.setName("Bilbo Baggins");
            assertEquals("Bilbo Baggins", player.getName());
        }

        @Test
        public void testSetPlayerHitPoints() {
            assertEquals(10, player.getHitPoints());

            player.setHitPoints(20);
            assertEquals(20, player.getHitPoints());
        }

        @Test
        public void testSetPlayerStrength() {
            assertEquals(50, player.getStrength());

            player.setStrength(100);
            assertEquals(100, player.getStrength());
        }

        @Test
        public void testSetPlayerWeapon() {
            assertEquals("Sword", player.getWeapon());

            player.setWeapon("Mace");
            assertEquals("Mace", player.getWeapon());
        }
    }

    @Nested
    @DisplayName("test Player to string")
    class TestPlayerToString {

        @Test
        public void testPlayerToString() {
            String expected = "Player{name='Tom Bombadil', hitPoints=10, strength=50, weapon='Sword'}";
            String result = player.toString();

            assertEquals(expected, result);
        }
    }

}
