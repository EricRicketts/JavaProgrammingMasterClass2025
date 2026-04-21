package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private Rectangle rectangle, singleArgumentRectangle, zeroArgumentRectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78));
        singleArgumentRectangle = new Rectangle(BigDecimal.valueOf(67.48));
        zeroArgumentRectangle = new Rectangle();
    }

    @Nested
    @DisplayName("Two argument constructor tests")
    class TwoArgumentConstructorTests {

        @Test
        public void testRectangleConstructorRejectsNullValueForLength() {
            assertEquals(
                    "Null value not allowed for length",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null, BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForLength() {
            assertEquals(
                    "Length is less than zero",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01), BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNullValueForWidth() {
            assertEquals(
                    "Null value not allowed for width",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), null)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForWidth() {
            assertEquals(
                    "Width is less than zero",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), BigDecimal.valueOf(-0.01))
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Single argument constructor tests")
    class SingleArgumentConstructorTests {

        @Test
        public void testSingleSidedRectangleRejectsNullValueForSide() {
            assertEquals(
                    "Null value not allowed for a side",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSingleSidedRectangleRejectsNegativeValueForSide() {
            assertEquals(
                    "Side is less than zero",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01))
                    ).getMessage()
            );

        }
    }

    @Test
    public void testGetRectangleLength() {
        assertEquals(BigDecimal.valueOf(31.52), rectangle.getLength());
    }

    @Test
    public void testGetRectangleWidth() {
        assertEquals(BigDecimal.valueOf(15.78), rectangle.getWidth());
    }

    @Test
    public void testSetRectangleLengthNullValue() {
        assertEquals(
                "Null value not allowed for length",
                assertThrows(
                NullPointerException.class,
                () -> rectangle.setLength(null)
            ).getMessage()
        );
    }

    @Test
    public void testSetRectangleLengthNegativeValue() {
        assertEquals(
                "Length is less than zero",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> rectangle.setLength(BigDecimal.valueOf(-10))
                ).getMessage()
        );
    }

    @Test
    public void testSetRectangleWidthNullValue() {
        assertEquals(
                "Null value not allowed for width",
                assertThrows(
                        NullPointerException.class,
                        () -> rectangle.setWidth(null)
                ).getMessage()
        );
    }

    @Test
    public void testSetRectangleWidthNegativeValue() {
        assertEquals(
                "Width is less than zero",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> rectangle.setWidth(BigDecimal.valueOf(-10))
                ).getMessage()
        );
    }

    @Test
    public void testGetRectangleArea() {
        assertEquals(BigDecimal.valueOf(497.39), rectangle.getArea());
    }

    @Test
    public void testGetLengthZeroArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(20.00), zeroArgumentRectangle.getLength());
    }

    @Test
    public void testGetWidthZeroArgumentRectangle() {
        assertEquals(BigDecimal.valueOf(10.00), zeroArgumentRectangle.getWidth());
    }
}
