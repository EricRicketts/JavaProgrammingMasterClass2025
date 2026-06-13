package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTest {

    private Circle circle;

    private final int scaleFactor = 2;

    @BeforeEach
    public void setUp() {
        circle = new Circle(new BigDecimal("4.53"), scaleFactor);
    }

    @Nested
    @DisplayName("test circle constructor validates radius")
    class TestCircleConstructorValidatesRadius {

        @Test
        public void testCircleConstructorRejectsNullRadius() {
            NullPointerException exception =
                assertThrows(
                    NullPointerException.class,
                    () -> new Circle(null, scaleFactor)
                );

                assertEquals(
                    ErrorMessages.nullValue("radius"),
                    exception.getMessage()
                );
        }

        @Test
        public void testCircleConstructorRejectsNegativeRadius() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Circle(new BigDecimal("-0.01"), scaleFactor)
                );

                assertEquals(
                    ErrorMessages.negativeValue("radius"),
                    exception.getMessage()
                );
        }
    }

    @Nested
    @DisplayName("test circle constructor validates scale factor")
    class TestCircleConstructorValidatesScaleFactor {

        @Test
        public void testCircleConstructorRejectsZeroScaleFactor() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Circle(new BigDecimal("1.45"), 0)
                );

                assertEquals(
                    ErrorMessages.zeroValue("scale factor"),
                    exception.getMessage()
                );
        }

        @Test
        public void testCircleConstructorRejectsNegativeScaleFactor() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Circle(new BigDecimal("1.45"), -1)
                );

                assertEquals(
                    ErrorMessages.negativeValue("scale factor"),
                    exception.getMessage()
                );
        }
    }

    @Nested
    @DisplayName("test circle setter validates radius")
    class TestCircleSetterValidatesRadius {

        @Test
        public void testCircleSetterRejectsNullRadius() {
            NullPointerException exception =
                assertThrows(
                    NullPointerException.class,
                    () -> circle.setRadius(null)
                );

                assertEquals(
                    ErrorMessages.nullValue("radius"),
                    exception.getMessage()
                );
        }

        @Test
        public void testCircleSetterRejectsNegativeRadius() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> circle.setRadius(new BigDecimal("-0.01"))
                );

                assertEquals(
                    ErrorMessages.negativeValue("radius"),
                    exception.getMessage()
                );
        }
    }

    @Nested
    @DisplayName("test circle radius getter")
    class TestCircleRadiusGetter {

        @Test
        public void testCircleOneArgumentConstructorGetRadius() {
            assertEquals(new BigDecimal("4.53"), circle.getRadius());
        }

        @Test
        public void testCircleZeroArgumentConstructorGetRadius() {
            assertEquals(new BigDecimal("1.54"), new Circle().getRadius());
        }
    }

    @Nested
    @DisplayName("test circle area snd circumference")
    class TestCircleAreaAndCircumference {

        @Test
        public void testCircleArea() {
            BigDecimal radius = new BigDecimal("4.53");
            BigDecimal unscaledExpectedArea = BigDecimal.valueOf(Math.PI).multiply(radius).multiply(radius);
            BigDecimal scaledExpectedArea = unscaledExpectedArea.setScale(scaleFactor, RoundingMode.HALF_UP);

            assertEquals(scaledExpectedArea, circle.area());
        }

        @Test
        public void testCircleCircumference() {
            BigDecimal radius = new BigDecimal("4.53");
            BigDecimal unscaledExpectedCircumference =
                new BigDecimal("2")
                    .multiply(new BigDecimal(Math.PI))
                    .multiply(radius);
            BigDecimal scaledExpectedCircumference =
                unscaledExpectedCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);

            assertEquals(scaledExpectedCircumference, circle.circumference());
        }

        @Test
        public void testZeroCircleArea() {
            Circle zeroCircle = new Circle(new BigDecimal("0.00"), scaleFactor);

            assertEquals(
                new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP),
                zeroCircle.area()
            );
        }
    }
}
