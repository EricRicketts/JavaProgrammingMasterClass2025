package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncrementerAndDecrementerTest {

    private int x;

    @Test
    public void testPostFixIncrementer() {
        x = 5;
        int y = x++; // 5 is assigned to "y" then x is incremented
        Assertions.assertArrayEquals(new int[]{5, 6}, new int[]{y, x});
    }

    @Test
    public void testPostFixDecrementer() {
        x = 5;
        int y = x--; // 5 is assigned to "y" then x is decremented
        Assertions.assertArrayEquals(new int[]{5, 4}, new int[]{y, x});
    }

    @Test
    public void testPreFixIncrementer() {
        x = 5;
        int y = ++x; // 5 is incremented then assigned to y
        Assertions.assertArrayEquals(new int[]{6, 6}, new int[]{y, x});
    }

    @Test
    public void testPreFixDecrementer() {
        x = 5;
        int y = --x; // 5 is decremented then assigned to y
        Assertions.assertArrayEquals(new int[]{4, 4}, new int[]{y, x});
    }
}
