package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private Rectangle rectangle;
    private static final int SCALE_FACTOR = 2;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78), SCALE_FACTOR);
    }

    @Nested
    @DisplayName("Rectangle constructor tests for width")
    class ConstructorWidthTests {

        @Test
        public void testRectangleConstructorRejectsNullValueForWidth() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null, BigDecimal.valueOf(10.45), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsZeroValueForWidth() {
            assertEquals(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(0.00), BigDecimal.valueOf(14.56), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForWidth() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01), BigDecimal.valueOf(10.45), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRoundsThreeDecimalWidth() {
            Rectangle rectangle =
                    new Rectangle(BigDecimal.valueOf(23.785), BigDecimal.valueOf(12.34), SCALE_FACTOR);
            assertEquals(BigDecimal.valueOf(23.79), rectangle.getWidth());
        }
    }

    @Nested
    @DisplayName("Rectangle constructor tests for height")
    class ConstructorHeightTests {

        @Test
        public void testRectangleConstructorRejectsNullValueForHeight() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), null, SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsZeroValueForHeight() {
            assertEquals(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(44.59), BigDecimal.valueOf(0.00), 2)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForHeight() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), BigDecimal.valueOf(-0.01), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRoundsThreeDecimalHeight() {
            Rectangle rectangle =
                    new Rectangle(BigDecimal.valueOf(23.78), BigDecimal.valueOf(12.344), SCALE_FACTOR);
            assertEquals(BigDecimal.valueOf(12.34), rectangle.getHeight());
        }
    }

/*

    @Nested
    @DisplayName("Scale Factor must be positive")
    class ScaleFactorTests {

        @Test
        public void testNegativeScaleFactor() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage(),
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Rectangle(BigDecimal.valueOf(10.45), BigDecimal.valueOf(43.56), -3)
                ).getMessage()
            );
        }

        @Test
        public void testZeroScaleFactor() {
            assertEquals(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), BigDecimal.valueOf(43.56), 0)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Rectangle single argument constructor tests")
    class SingleArgumentConstructorTests {

        @Test
        public void testSingleArgumentRectangleConstructorRejectsNullValue() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null, SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testSingleArgumentRectangleConstructorRejectsNegativeValue() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-9.56), SCALE_FACTOR)
                    ).getMessage()
            );
        }

        @Test
        public void testSingleArgumentRectangleHasSameWidthAndHeight() {
            assertEquals(BigDecimal.valueOf(13.45), singleArgumentRectangle.getWidth());
            assertEquals(BigDecimal.valueOf(13.45), singleArgumentRectangle.getHeight());
        }
    }

    @Nested
    @DisplayName("Rectangle getter tests")
    class RectangleGetterTests {

        @Test
        public void testGetRectangleWidth() {
            assertEquals(BigDecimal.valueOf(31.52), rectangle.getWidth());
        }

        @Test
        public void testGetRectangleHeight() {
            assertEquals(BigDecimal.valueOf(15.78), rectangle.getHeight());
        }

        @Test
        public void testGetRectangleArea() {
            assertEquals(BigDecimal.valueOf(497.39), rectangle.area());
        }
    }

    @Nested
    @DisplayName("Rectangle toString test")
    class RectangleToStringTest {
        // As with the coordinate tests, the data to check in the toString test is so small
        // that it does not make sense to try to extract essential data for the test, just test
        // the entire string.
        @Test
        public void testRectangleToString() {
            String expected = "Rectangle[width = 31.52, height = 15.78]";
            String actual = rectangle.toString();
            assertEquals(expected, actual);
        }
    }

    */
}