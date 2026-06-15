package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {

    private NullPointerException nullPointerException;

    private IllegalArgumentException illegalArgumentException;

    private Square square;

    private Square defaultSquare;

    private static final int SCALE_FACTOR = 3;

    private static final String SCALE_FACTOR_ERROR_MESSAGE =
        "Scale factor is too large.";

    private static final BigDecimal SIDE = BigDecimal.valueOf(56.98);

    private final String literalSide = "side";

    private final String literalScaleFactor = "scale factor";

    @BeforeEach
    public void setUp() {
        square = new Square(SIDE, SCALE_FACTOR);
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
                    ErrorMessages.nullValue(literalSide),
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
                    ErrorMessages.negativeValue(literalSide),
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
                ErrorMessages.negativeValue(literalScaleFactor),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testSquareConstructorRejectsTooHighAScaleFactor() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> new Square(BigDecimal.valueOf(11.45), 11)
            );

            assertEquals(
                SCALE_FACTOR_ERROR_MESSAGE,
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

        @Test
        public void testSquareSetterRejectsNullSide() {
            nullPointerException = assertThrows(
                NullPointerException.class,
                () -> square.setSide(null)
            );

            assertEquals(
                ErrorMessages.nullValue(literalSide),
                nullPointerException.getMessage()
            );
        }

        @Test
        public void testSquareSetterRejectsNegativeSide() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> square.setSide(BigDecimal.valueOf(-4.56))
            );

            assertEquals(
                ErrorMessages.negativeValue(literalSide),
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test square setter validates scale factor")
    class TestSquareSetterValidatesScaleFactor {

        @Test
        public void testSquareSetterRejectsNegativeScaleFactor() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> square.setScaleFactor(-5)
            );

            assertEquals(
                ErrorMessages.negativeValue(literalScaleFactor),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testSquareSetterRejectsTooHighAScaleFactor() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> square.setScaleFactor(11)
            );

            assertEquals(
                SCALE_FACTOR_ERROR_MESSAGE,
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test square side and scale factor getters")
    class TestSquareSideAndScaleFactorGetters {

        @Test
        public void testSquareGetSide() {
            assertEquals(SIDE, square.getSide());
        }

        @Test
        public void testSquareGetScaleFactor() {
            assertEquals(SCALE_FACTOR, square.getScaleFactor());
        }
    }

    @Nested
    @DisplayName("test square area")
    class TestSquareArea {

        @Test
        public void testSquareArea() {
            BigDecimal side = BigDecimal.valueOf(14.567);
            square = new Square(side, SCALE_FACTOR);

            BigDecimal unscaledArea = side.multiply(side);
            BigDecimal scaledArea =
                unscaledArea.setScale(SCALE_FACTOR, RoundingMode.HALF_UP);

            assertEquals(scaledArea, square.area());
        }

        @Test
        public void testSquareAreaZeroScaleFactor() {
            square = new Square(BigDecimal.valueOf(20.543), 0);

            assertEquals(BigDecimal.valueOf(422), square.area());
        }

        @Test
        public void testSquareAreaZeroSquare() {
            square = new Square(new BigDecimal("0.000"), SCALE_FACTOR);

            assertEquals(new BigDecimal("0.000"), square.area());
        }
    }

    @Nested
    @DisplayName("test square perimeter")
    class TestSquarePerimeter {

        @Test
        public void testSquarePerimeter() {
            BigDecimal side = BigDecimal.valueOf(87.592);
            Square square = new Square(side, SCALE_FACTOR);

            BigDecimal unscaledPerimeter = BigDecimal.valueOf(4).multiply(side);
            BigDecimal scaledPerimeter =
                unscaledPerimeter.setScale(SCALE_FACTOR, RoundingMode.HALF_UP);

            assertEquals(scaledPerimeter, square.perimeter());
        }

        @Test
        public void testSquarePerimeterZeroScaleFactor() {
            square = new Square(BigDecimal.valueOf(23.456), 0);

            assertEquals(BigDecimal.valueOf(94), square.perimeter());
        }

        @Test
        public void testSquarePerimeterZeroSquare() {
            square = new Square(new BigDecimal("0.000"), SCALE_FACTOR);

            assertEquals(new BigDecimal("0.000"), square.perimeter());
        }
    }
}
