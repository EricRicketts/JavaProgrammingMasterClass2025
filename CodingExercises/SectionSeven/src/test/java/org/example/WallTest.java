package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    Wall firstWall, secondWall;

    @BeforeEach
    public void setUp() {
        firstWall = new Wall(-1.56, -0.004);
        secondWall = new Wall(8.29, 9.87);
    }

    @Test
    public void testFirstWallWidthAndHeightSetToZero() {
        assertEquals(0, firstWall.getWidth());
        assertEquals(0, firstWall.getHeight());
    }

    @Test
    public void testSetFirstWallWidth() {
        firstWall.setWidth(4.2345);
        assertEquals(4.23, firstWall.getWidth());
    }

    @Test
    public void testSetterInvalidData() {
        firstWall.setWidth(-0.45);
        firstWall.setHeight(-5.23);
        assertArrayEquals(new double[]{0, 0},
                new double[]{firstWall.getWidth(), firstWall.getHeight()}
        );
    }

    @Test
    public void testSecondWallArea() {
        assertEquals(81.82, secondWall.getArea());
    }
}
