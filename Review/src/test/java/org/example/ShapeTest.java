package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShapeTest {

    @Test
    public void testShapeArea() {
        assertEquals(new BigDecimal("1.5"), new Shape().area());
    }
}
