package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTest {

    private Circle firstCircle;

    private Circle secondCircle;

    @BeforeEach
    public void setUp() {
        firstCircle = new Circle(new BigDecimal("4.5"));
        secondCircle = new Circle();
    }

    @Nested
    @DisplayName("test circle validates radius")
    class TestCircleValidatesRadius {

        @Test
        public void testCircleConstructorRejectsNullRadius() {
            NullPointerException exception =
                assertThrows(
                    NullPointerException.class,
                    () -> new Circle(null)
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
                    () -> new Circle(new BigDecimal("-0.01"))
                );

            assertEquals(
                ErrorMessages.negativeValue("radius"),
                exception.getMessage()
            );
        }

    }
}
