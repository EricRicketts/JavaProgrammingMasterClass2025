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
    private static final int SCALE_FACTOR = 2;

    @BeforeEach
    public void setUp() {
        square = new Square(BigDecimal.valueOf(56.98), SCALE_FACTOR);
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
                            () -> new Square(null, SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testSquareConstructorRejectsNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for a side",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Square(BigDecimal.valueOf(-4), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testSquareConstructorRoundsThreeDecimalSide() {
            Square square =
                    new Square(BigDecimal.valueOf(59.458), SCALE_FACTOR);
            assertEquals(BigDecimal.valueOf(59.46), square.getSide());
        }
    }

    @Nested
    @DisplayName("Scale Factor must be positive")
    class ScaleFactorTests {

        @Test
        public void testNegativeScaleFactor() {
            assertEquals(
                    "Negative or zero value is not allowed for a scale factor",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Square(BigDecimal.valueOf(10.45), -3)
                    ).getMessage()
            );
        }

        @Test
        public void testZeroScaleFactor() {
            assertEquals(
                    "Negative or zero value is not allowed for a scale factor",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Square(BigDecimal.valueOf(43.56), 0)
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
