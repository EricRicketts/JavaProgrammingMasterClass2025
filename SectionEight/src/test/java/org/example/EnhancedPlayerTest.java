package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnhancedPlayerTest {

    EnhancedPlayer player;

    @BeforeEach
    public void setUp() {
        player = new EnhancedPlayer("Tim");
    }

    @Test
    public void testInitialStateOfEnhancedPlayer() {
        Object[] expected = new Object[]{"Tim", 100, "Sword"};
        Object[] results = new Object[]{
                player.getFullName(), player.healthRemaining(), player.getWeapon()
        };
        assertArrayEquals(expected, results);
    }
}
