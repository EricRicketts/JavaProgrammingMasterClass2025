package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private Rectangle rectangle, zeroArgumentRectangle;
    private Rectangle square;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78));
        square = new Rectangle(BigDecimal.valueOf(67.48));
        zeroArgumentRectangle = new Rectangle();
    }

    @Nested
    @DisplayName("Rectangle two argument constructor tests")
    class TwoArgumentConstructorTests {

        @Test
        public void testRectangleConstructorRejectsNullValueForLength() {
            assertEquals(
                    "Null value is not allowed for length",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null, BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForLength() {
            assertEquals(
                    "Negative value is not allowed for length",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01), BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNullValueForWidth() {
            assertEquals(
                    "Null value is not allowed for width",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), null)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForWidth() {
            assertEquals(
                    "Negative value is not allowed for width",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), BigDecimal.valueOf(-0.01))
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Rectangle single argument constructor tests")
    class SingleArgumentConstructorTests {

        @Test
        public void testSingleSidedRectangleRejectsNullValueForSide() {
            assertEquals(
                    "Null value is not allowed for a side",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSingleSidedRectangleRejectsNegativeValueForSide() {
            assertEquals(
                    "Negative value is not allowed for a side",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01))
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Rectangle zero argument object tests")
    class ZeroArgumentConstructorTests {

        @Test
        public void testGetLengthZeroArgumentRectangle() {
            assertEquals(BigDecimal.valueOf(20.00), zeroArgumentRectangle.getLength());
        }

        @Test
        public void testGetWidthZeroArgumentRectangle() {
            assertEquals(BigDecimal.valueOf(10.00), zeroArgumentRectangle.getWidth());
        }
    }

    @Nested
    @DisplayName("square getter, setter and area tests")
    class SingleArgumentRectangleGetterAndSetterTests {

        @Test
        public void testSquareGetSide() {
            assertEquals(BigDecimal.valueOf(67.48), square.getSquare().getSide());
        }

        @Test
        public void testSquareGetArea() {
            assertEquals(BigDecimal.valueOf(4_553.55), square.getSquare().getArea());
        }

        @Test
        public void testSquareSetSide() {
            square.getSquare().setSide(BigDecimal.valueOf(84.76));
            assertEquals(BigDecimal.valueOf(84.76), square.getSquare().getSide());
        }
    }

    @Nested
    @DisplayName("Rectangle getter tests")
    class RectangleGetterTests {

        @Test
        public void testGetRectangleLength() {
            assertEquals(BigDecimal.valueOf(31.52), rectangle.getLength());
        }

        @Test
        public void testGetRectangleWidth() {
            assertEquals(BigDecimal.valueOf(15.78), rectangle.getWidth());
        }

        @Test
        public void testGetRectangleArea() {
            assertEquals(BigDecimal.valueOf(497.39), rectangle.getArea());
        }
    }

    @Nested
    @DisplayName("Rectangle setter tests")
    class RectangleSetterTests {

        @Test
        public void testSetRectangleLengthNullValue() {
            assertEquals(
                    "Null value is not allowed for length",
                    assertThrows(
                    NullPointerException.class,
                    () -> rectangle.setLength(null)
                ).getMessage()
            );
        }

        @Test
        public void testSetRectangleLengthNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for length",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> rectangle.setLength(BigDecimal.valueOf(-10))
                    ).getMessage()
            );
        }

        @Test
        public void testSetRectangleWidthNullValue() {
            assertEquals(
                    "Null value is not allowed for width",
                    assertThrows(
                            NullPointerException.class,
                            () -> rectangle.setWidth(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSetRectangleWidthNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for width",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> rectangle.setWidth(BigDecimal.valueOf(-10))
                    ).getMessage()
            );
        }

        @Test
        public void testSetRectangleLength() {
            rectangle.setLength(BigDecimal.valueOf(78.43));
            assertEquals(BigDecimal.valueOf(78.43), rectangle.getLength());
        }

        @Test
        public void testSetRectangleWidth() {
            rectangle.setWidth(BigDecimal.valueOf(54.76));
            assertEquals(BigDecimal.valueOf(54.76), rectangle.getWidth());
        }
    }

    @Nested
    @DisplayName("Rectangle toString test")
    class RectangleToStringTest {

        @Test
        public void testRectangleToString() {
            // 31.52; 15.78
            String expected = "Rectangle[length = 31.52, width = 15.78]";
            String actual = rectangle.toString();
            assertEquals(expected, actual);
        }
    }
}
