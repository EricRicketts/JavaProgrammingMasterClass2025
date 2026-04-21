package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("Constructor tests")
    class SquareConstructorTests {

        @Test
        public void testSquareConstructorRejectsNullValue() {
            assertEquals(
                    "Null value is not allowed for a side",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Square(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSquareConstructorRejectsNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for a side",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Square(BigDecimal.valueOf(-4))
                    ).getMessage()
            );
        }
    }

    @Test
    public void testSquareSetAndGetSide() {
        square.setSide(BigDecimal.valueOf(89.12));
        assertEquals(BigDecimal.valueOf(89.12), square.getSide());
    }

    @Test
    public void testSquareSetSideNullValue() {
        assertEquals(
                "Null value is not allowed for a side",
                assertThrows(
                        NullPointerException.class,
                        () -> square.setSide(null)
                ).getMessage()
        );
    }

    @Test
    public void testSquareSetSideNegativeValue() {
        assertEquals(
                "Negative value is not allowed for a side",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> square.setSide(BigDecimal.valueOf(-5))
                ).getMessage()
        );
    }

    @Test
    public void testSquareGetArea() {
        assertEquals(BigDecimal.valueOf(3_246.72), square.getArea());
    }
}
