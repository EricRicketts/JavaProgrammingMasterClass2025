package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlourPackerTest {

    boolean result;
    @Test
    public void testCanPackInvalidPositiveValues() {
        result = FlourPacker.canPack(1, 0, 4);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCanPackValidValues() {
        result = FlourPacker.canPack(-1, 4, 4);
        Assertions.assertFalse(result);
    }
    @Test
    public void testCanPackOneZeroAndFive() {
        result = FlourPacker.canPack(1, 0, 5);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCanPackZeroFiveFour() {
        result = FlourPacker.canPack(0, 5, 4);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCanPackTwoTwoEleven() {
        result = FlourPacker.canPack(2, 2, 11);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCanPackOneZeroSix() {
        result = FlourPacker.canPack(1, 0, 6);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCanPackZeroFiveSix() {
        result = FlourPacker.canPack(3, 7, 21);
        Assertions.assertTrue(result);
    }
}
