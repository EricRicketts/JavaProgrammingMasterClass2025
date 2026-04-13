package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericUtilsTest {

    @Test
    public void testSetScaleLower() {
        assertEquals(35.12, NumericUtils.setScale(35.1234, 2));
    }

    @Test
    public void testSetScaleHigher() {
        assertEquals(35.13, NumericUtils.setScale(35.1256, 2));
    }
}
