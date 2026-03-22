package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OblongTest {
    Oblong firstOblong, secondOblong;
    int[] expected, result;

    @BeforeEach
    public void setUp() {
        firstOblong = new Oblong(2, 3, 4, 5);
        secondOblong = new Oblong(6, 7);
    }

    @Test
    public void testFirstOblong() {
        expected = new int[]{2, 3, 4, 5};
        result = new int[]{
            firstOblong.getX(), firstOblong.getY(),
            firstOblong.getWidth(), firstOblong.getHeight()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSecondOblong() {
        expected = new int[]{6, 7, 0, 0};
        result = new int[]{
                secondOblong.getX(), secondOblong.getY(),
                secondOblong.getWidth(), secondOblong.getHeight()
        };
        assertArrayEquals(expected, result);
    }
}
