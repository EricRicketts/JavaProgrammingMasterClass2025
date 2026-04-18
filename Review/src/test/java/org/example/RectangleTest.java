package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78));
    }

    @Test
    public void testGetRectangleLength() {
        assertEquals(BigDecimal.valueOf(31.52), rectangle.getLength());
    }

    @Test
    public void testGetRectangleWidth() {
        assertEquals(BigDecimal.valueOf(15.78), rectangle.getWidth());
    }
}
