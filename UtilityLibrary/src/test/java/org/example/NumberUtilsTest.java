package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {

    @Test
    public void testSetScaleLower() {
        assertEquals(
                35.12,
                NumberUtils.setScale(35.1243, 2),
                0.01
        );
    }
}
