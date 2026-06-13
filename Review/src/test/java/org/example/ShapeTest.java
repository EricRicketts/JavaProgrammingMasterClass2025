package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeTest {

    private Shape firstShape;
    private Shape secondShape;

    @BeforeEach
    public void setUp() {
        firstShape = new Shape(5, 4);
        secondShape = new Shape();
    }

    @Nested
    @DisplayName("test shape constructors set fields")
    class TestShapeConstructorsSetFields {

        @Test
        public void testTwoArgumentShapeConstructorSetsLength() {
            assertEquals(5, firstShape.getLength());
        }

        @Test
        public void testTwoArgumentShapeConstructorSetsWidth() {
            assertEquals(4, firstShape.getWidth());
        }

        @Test
        public void testNoArgumentShapeConstructorSetsLength() {
            assertEquals(1, secondShape.getLength());
        }

        @Test
        public void testNoArgumentShapeConstructorSetsWidth() {
            assertEquals(1, secondShape.getWidth());
        }
    }

    @Nested
    @DisplayName("test shape constructor validation")
    class TestShapeConstructorValidation {

        @Test
        public void testShapeConstructorRejectsNegativeLength() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Shape(-1, 1)
            );

            assertEquals(
                ErrorMessages.negativeValue("length"),
                exception.getMessage()
            );
        }

        @Test
        public void testShapeConstructorRejectsZeroLength() {
            IllegalArgumentException exception =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Shape(0, 1)
                );

            assertEquals(
                ErrorMessages.zeroValue("length"),
                exception.getMessage()
            );
        }
    }
}
