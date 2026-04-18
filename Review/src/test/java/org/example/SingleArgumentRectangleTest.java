package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleArgumentRectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(13.67));
    }

    @Test
    public void testGetLengthSingleArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(13.67), rectangle.getLength());
    }

    @Test
    public void testGetWidthSingleArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(13.67), rectangle.getWidth());
    }
}
