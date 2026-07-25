package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        public void testMonsterToString() {
            String expected = "Monster{name='Werewolf', hitPoints=20, strength=40}";
            String result = monster.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test monster read and write")
    class MonsterReadAndWrite {

        @Test
        public void testMonsterRead() {
            monster.read(List.of("Vampire", "25", "45"));

            assertEquals("Vampire", monster.getName());
            assertEquals(25, monster.getHitPoints());
            assertEquals(45, monster.getStrength());
        }

        @Test
        public void testMonsterWrite() {
            List<String> expected = List.of("Werewolf", "20", "40");
            List<String> result = monster.write();

            assertEquals(expected, result);
        }
    }

}
