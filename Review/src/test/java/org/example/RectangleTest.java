package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private Rectangle rectangle, singleArgumentRectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(BigDecimal.valueOf(31.52), BigDecimal.valueOf(15.78));
        singleArgumentRectangle = new Rectangle(BigDecimal.valueOf(13.45));
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

        @Test
        public void testRectangleToString() {
            String expected = "Rectangle[width = 31.52, height = 15.78]";
            String actual = rectangle.toString();
            assertEquals(expected, actual);
        }
    }
}
