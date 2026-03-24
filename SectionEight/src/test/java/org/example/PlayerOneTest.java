package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerOneTest {

    PlayerOne player;
    String expected, result;

    @BeforeEach
    public void setUp() {
        player = new PlayerOne();
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";
    }

    @Test
    public void testIssuesWithNoEncapsulation() {
        /*
            A significant downside of lack of encapsulation means that the
            receiving user must initialize the state of the object.  This is
            shown in the setUp() method above.  Initializing the data should
            be the responsibility of the class constructor methods.  The creator
            of the class knows best how to set an object to a valid state.
        */
        assertArrayEquals(
            new Object[]{"Tim", 20, "Sword"},
            new Object[]{player.name, player.health, player.weapon}
        );
    }

    @Test
    public void testHealthSetDirectly() {
        /*
            This is a significant problem; a key attribute, health, is being set
            without use of one of the methods designed to update the health, i.e.,
            restoreHealth() and looseHealth().  We see that the player health was
            set to 200 which would not be allowed with the restoreHealth() method.
            Thus the object has lost control of one of its attributes.

            Thus, without encapsulation by allowing direct access to data, checks
            and additional processing on the data defined in the class will be
            bypassed.

            Additionally, allowing direct access to a field means the calling code needs
            to be changed if a field name is changed.
        */
        result = player.looseHealth(10);
        expected = "The player's health is sufficient to remain in the game.";
        assertEquals(expected, result);
        player.health = 200;
        assertEquals(200, player.health);
    }
}
