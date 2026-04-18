package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {

    private Square square;

    @BeforeEach
    public void setUp() {
        square = new Square(BigDecimal.valueOf(56.98));
    }

    @Test
    public void testSquareGetSide() {
        assertEquals(BigDecimal.valueOf(56.98), square.getSide());
    }

    @Test
    public void testSquareSetSideWithNullValue() {
        assertEquals(
                "Null value not allowed for a side",
                assertThrows(
                        NullPointerException.class,
                        () -> square.setSide(null)
                ).getMessage()
        );
    }
}
