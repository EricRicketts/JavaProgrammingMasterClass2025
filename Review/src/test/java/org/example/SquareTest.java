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

    private static final int SCALE_FACTOR = 2;

    private final String literalSide = "side";

    private final String literalScaleFactor = "scale factor";

    @BeforeEach
    public void setUp() {
        square = new Square(BigDecimal.valueOf(56.98), SCALE_FACTOR);
    }

    @Nested
    @DisplayName("test square constructor validates side")
    class TestSquareConstructorValidatesSide {

        @Test
        public void testSquareConstructorRejectsSideNullValue() {
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
        public void testSquareConstructorRejectsSideNegativeValue() {
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

    }

    @Nested
    @DisplayName("test no argument square constructor")
    class TestNoArgumentSquareConstructor {

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
