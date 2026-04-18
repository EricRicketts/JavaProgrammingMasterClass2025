package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroArgumentRectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle();
    }

    @Test
    public void testGetLengthZeroArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(20.00), rectangle.getLength());
    }

    @Test
    public void testGetWidthZeroArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(10.00), rectangle.getWidth());
    }
}
