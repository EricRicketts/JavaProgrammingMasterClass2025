package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setUp() {
        monster = new Monster("Werewolf", 20, 40);
    }

    @Nested
    @DisplayName("test monster getters")
    class TestPlayerGetters {

        @Test
        public void testGetMonsterName() {
            assertEquals("Werewolf", monster.getName());
        }

        @Test
        public void testGetMonsterHitPoints() {
            assertEquals(20, monster.getHitPoints());
        }

        @Test
        public void testGetMonsterStrength() {
            assertEquals(40, monster.getStrength());
        }
    }

    @Nested
    @DisplayName("test Monster to string")
    class TestPlayerToString {

        @Test
        public void testPlayerToString() {
            String expected = "Monster{name='Tom Bombadil', hitPoints=10, strength=50, weapon='Sword'}";
            String result = monster.toString();

            assertEquals(expected, result);
        }
    }

}
