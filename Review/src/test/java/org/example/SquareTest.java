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
    @DisplayName("Square constructor tests")
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

    @Nested
    @DisplayName("Square getter tests")
    class SquareGetterTests {

        @Test
        public void testSquareGetSide() {
            assertEquals(BigDecimal.valueOf(56.98), square.getSide());
        }

        @Test
        public void testSquareArea() {
            assertEquals(BigDecimal.valueOf(3_246.72), square.area());
        }
    }

    @Nested
    @DisplayName("Square toString test")
    class SquareToStringTest {

        @Test
        public void testSquareToString() {
            String expected = "Square[side = 56.98]";
            String actual = square.toString();

            assertEquals(expected, actual);
        }
    }
}
