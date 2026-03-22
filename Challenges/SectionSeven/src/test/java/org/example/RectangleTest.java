package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RectangleTest {

    Rectangle firstRectangle, secondRectangle, thirdRectangle;
    int[] expected, result;

    @BeforeEach
    public void setUp() {
        firstRectangle = new Rectangle(2, 3, 5, 10);
        secondRectangle = new Rectangle(8, 16);
        thirdRectangle = new Rectangle();
    }

    @Test
    public void testFirstRectangle() {
        expected = new int[]{2, 3, 5, 10};
        result = new int[]{
                firstRectangle.getX(),
                firstRectangle.getY(),
                firstRectangle.getWidth(),
                firstRectangle.getHeight()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSecondRectangle() {
        expected = new int[]{0, 0, 8, 16};
        result = new int[]{
                secondRectangle.getX(),
                secondRectangle.getY(),
                secondRectangle.getWidth(),
                secondRectangle.getHeight()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThirdRectangle() {
        expected = new int[]{0, 0, 0, 0};
        result = new int[]{
                thirdRectangle.getX(),
                thirdRectangle.getY(),
                thirdRectangle.getWidth(),
                thirdRectangle.getHeight()
        };
        assertArrayEquals(expected, result);
    }
}
