package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {

    @Test
    public void testSetScaleLower() {
        BigDecimal expected = BigDecimal.valueOf(35.12);
        BigDecimal actual = NumberUtils.setScale(BigDecimal.valueOf(35.1243), 2);
        assertEquals(0, expected.compareTo(actual), 0.01);
    }

    @Test
    public void testSetScaleHigher() {
        BigDecimal expected = BigDecimal.valueOf(35.13);
        BigDecimal actual = NumberUtils.setScale(BigDecimal.valueOf(35.1254), 2);
        assertEquals(0, expected.compareTo(actual), 0.01);
    }
}
