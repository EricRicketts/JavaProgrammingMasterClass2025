package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private Rectangle rectangle, zeroArgumentRectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78));
        zeroArgumentRectangle = new Rectangle();
    }

    @Nested
    @DisplayName("Rectangle two argument constructor tests")
    class TwoArgumentConstructorTests {

        @Test
        public void testRectangleConstructorRejectsNullValueForWidth() {
            assertEquals(
                    "Null value is not allowed for width",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null, BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForWidth() {
            assertEquals(
                    "Negative value is not allowed for width",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-0.01), BigDecimal.valueOf(10.45))
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNullValueForHeight() {
            assertEquals(
                    "Null value is not allowed for height",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(BigDecimal.valueOf(10.45), null)
                    ).getMessage()
            );
        }

        @Test
        public void testRectangleConstructorRejectsNegativeValueForHeight() {
            assertEquals(
                    "Negative value is not allowed for height",
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
        public void testSingleArgumentRectangleConstructorRejectsNullValue() {
            assertEquals(
                    "Null value is not allowed for width",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Rectangle(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSingleArgumentRectangleConstructorRejectsNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for width",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Rectangle(BigDecimal.valueOf(-9.56))
                    ).getMessage()
            );
        }

        @Test
        public void testSingleArgumentRectangleHasSameWidthAndHeight() {
            Rectangle rectangle = new Rectangle(BigDecimal.valueOf(13.45));
            assertTrue(
                    BigDecimal.valueOf(13.45).equals(rectangle.getWidth()) &&
                    rectangle.getWidth().equals(rectangle.getHeight())
            );
        }
    }

    @Nested
    @DisplayName("Rectangle zero argument object tests")
    class ZeroArgumentConstructorTests {

        @Test
        public void testGetWidthZeroArgumentRectangle() {
            assertEquals(BigDecimal.valueOf(20.00), zeroArgumentRectangle.getWidth());
        }

        @Test
        public void testGetHeightZeroArgumentRectangle() {
            assertEquals(BigDecimal.valueOf(10.00), zeroArgumentRectangle.getHeight());
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
            assertEquals(BigDecimal.valueOf(497.39), rectangle.getArea());
        }
    }

    @Nested
    @DisplayName("Rectangle setter tests")
    class RectangleSetterTests {

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
        public void testSetRectangleHeightNullValue() {
            assertEquals(
                    "Null value is not allowed for height",
                    assertThrows(
                    NullPointerException.class,
                    () -> rectangle.setHeight(null)
                ).getMessage()
            );
        }

        @Test
        public void testSetRectangleHeightNegativeValue() {
            assertEquals(
                    "Negative value is not allowed for height",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> rectangle.setHeight(BigDecimal.valueOf(-10))
                    ).getMessage()
            );
        }

        @Test
        public void testSetRectangleWidth() {
            rectangle.setWidth(BigDecimal.valueOf(54.76));
            assertEquals(BigDecimal.valueOf(54.76), rectangle.getWidth());
        }

        @Test
        public void testSetRectangleHeight() {
            rectangle.setHeight(BigDecimal.valueOf(78.43));
            assertEquals(BigDecimal.valueOf(78.43), rectangle.getHeight());
        }
    }

    @Nested
    @DisplayName("Rectangle toString test")
    class RectangleToStringTest {

        @Test
        public void testRectangleToString() {
            // 31.52; 15.78
            String expected = "Rectangle[width = 31.52, height = 15.78]";
            String actual = rectangle.toString();
            assertEquals(expected, actual);
        }
    }
}
