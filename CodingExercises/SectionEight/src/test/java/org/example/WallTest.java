package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    @Test
    public void testWall() {
        Wall wall = new Wall("right");
        assertEquals("right", wall.getDirection());
    }
}
