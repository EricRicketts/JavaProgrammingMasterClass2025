package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {

    private NullPointerException nullPointerException;

    private IllegalArgumentException illegalArgumentException;

    private Square square;

    private Square defaultSquare;

    private static final int SCALE_FACTOR = 2;

    private final String literalSide = "side";

    private final String literalScaleFactor = "scale factor";

    @BeforeEach
    public void setUp() {
        square = new Square(BigDecimal.valueOf(56.98), SCALE_FACTOR);
        defaultSquare = new Square();
    }

    @Nested
    @DisplayName("test square constructor validates side")
    class TestSquareConstructorValidatesSide {

        @Test
        public void testSquareConstructorRejectsNullSideValue() {
                nullPointerException = assertThrows(
                    NullPointerException.class,
                    () -> new Square(null, SCALE_FACTOR)
                );

                assertEquals(
                    ErrorMessages.nullValue("side"),
                    nullPointerException.getMessage()
                );
        }

        @Test
        public void testSquareConstructorRejectsNegativeSideValue() {
                illegalArgumentException = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Square(BigDecimal.valueOf(-4), SCALE_FACTOR)
                );

                assertEquals(
                    ErrorMessages.negativeValue("side"),
                    illegalArgumentException.getMessage()
                );
        }
    }

    @Nested
    @DisplayName("test square constructor validates scale factor")
    class TestSquareConstructorValidatesScaleFactor {

        @Test
        public void testSquareConstructorRejectsNegativeScaleFactor() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> new Square(BigDecimal.valueOf(4), -1)
            );

            assertEquals(
                ErrorMessages.negativeValue("scale factor"),
                illegalArgumentException.getMessage()
            );
        }

    }

    @Nested
    @DisplayName("test no argument square constructor")
    class TestNoArgumentSquareConstructor {

        @Test
        public void testNoArgumentSquareConstructorHasSide() {
            assertEquals(BigDecimal.valueOf(2), defaultSquare.getSide());
        }

        @Test
        public void testNoArgumentSquareConstructorHasScaleFactor() {
            assertEquals(2, defaultSquare.getScaleFactor());
        }

    }

    @Nested
    @DisplayName("test square setter validates side")
    class TestSquareSetterValidatesSide {

    }

    @Nested
    @DisplayName("test square setter validates scale factor")
    class TestSquareSetterValidatesScaleFactor {

    }

    @Nested
    @DisplayName("test square side and scale factor getters")
    class TestSquareSideAndScaleFactorGetters {

    }

    @Nested
    @DisplayName("test square area")
    class TestSquareArea {

    }

    @Nested
    @DisplayName("test square perimieter")
    class TestSquarePerimeter {

    }
}
