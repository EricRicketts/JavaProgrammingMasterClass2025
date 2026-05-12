package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueValidatorTest {

    @Nested
    @DisplayName("test ValidateTextAndReturn")
    class TestValidateTextAndReturn {

        @Test
        public void testNullValueThrowsException() {
            assertEquals(
                    ErrorMessages.nullValue("field"),
                    assertThrows(
                            NullPointerException.class,
                            () -> ValueValidator.validateTextAndReturn(null, "field")
                    ).getMessage()
            );
        }

        @Test
        public void testEmptyValueThrowsException() {
            assertEquals(
                    ErrorMessages.emptyValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validateTextAndReturn("", "field")
                    ).getMessage()
            );
        }

        @Test
        public void testBlankValueThrowsException() {
            assertEquals(
                    ErrorMessages.blankValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validateTextAndReturn("  ", "field")
                    ).getMessage()
            );
        }

        @Test
        public void testValidReturnValue() {
            assertEquals(
                    "foo",
                    ValueValidator.validateTextAndReturn("foo", "field")
            );
        }
    }

    @Nested
    @DisplayName("test validatePositiveIntAndReturn")
    class TestValidatePositiveIntAndReturn {

        @Test
        public void testZeroValueThrowsException() {
            assertEquals(
                    ErrorMessages.zeroValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validatePositiveIntAndReturn(0, "field")
                    ).getMessage()
            );
        }

        @Test
        public void testNegativeValueThrowsException() {
            assertEquals(
                    ErrorMessages.negativeValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validatePositiveIntAndReturn(-3, "field")
                    ).getMessage()
            );
        }

        @Test
        public void testValidReturnValue() {
            assertEquals(
                    3,
                    ValueValidator.validatePositiveIntAndReturn(3, "field")
            );
        }
    }

    @Nested
    @DisplayName("test validatePositiveBigDecimalAndReturn")
    class TestValidatePositiveBigDecimalAndReturn {

        @Test
        public void testNullValueThrowsException() {
            assertEquals(
                    ErrorMessages.nullValue("field"),
                    assertThrows(
                            NullPointerException.class,
                            () -> ValueValidator.validatePositiveBigDecimalAndReturn(null, "field")
                    ).getMessage()
            );
        }

        @Test
        public void testZeroValueThrowsException() {
            assertEquals(
                    ErrorMessages.zeroValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validatePositiveBigDecimalAndReturn(BigDecimal.valueOf(0), "field")
                    ).getMessage()
            );
        }

        @Test
        public void testNegativeValueThrowsException() {
            assertEquals(
                    ErrorMessages.negativeValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validatePositiveBigDecimalAndReturn(BigDecimal.valueOf(-4.33), "field")
                    ).getMessage()
            );
        }

        @Test
        public void testValidBigDecimalAndReturn() {
            assertEquals(
                    BigDecimal.valueOf(3.45),
                    ValueValidator.validatePositiveBigDecimalAndReturn(BigDecimal.valueOf(3.45), "field")
            );
        }
    }

    @Nested
    @DisplayName("test nonNegativeBigDecimalAndReturn")
    class TestValidateNonNegativeBigDecimalAndReturn {

        @Test
        public void testNullValueThrowsException() {
            assertEquals(
                    ErrorMessages.nullValue("field"),
                    assertThrows(
                            NullPointerException.class,
                            () -> ValueValidator.validateNonNegativeBigDecimalAndReturn(null, "field")
                    ).getMessage()
            );
        }

        @Test
        public void testNegativeValueThrowsException() {
            assertEquals(
                    ErrorMessages.negativeValue("field"),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.validateNonNegativeBigDecimalAndReturn(BigDecimal.valueOf(-3.45), "field")
                    ).getMessage()
            );
        }

        @Test
        public void testValidBigDecimalAndReturn() {
            assertEquals(
                    BigDecimal.valueOf(3.45),
                    ValueValidator.validateNonNegativeBigDecimalAndReturn(BigDecimal.valueOf(3.45), "field")
            );
        }
    }

    @Nested
    @DisplayName("test scale positive BigDecimal")
    class TestValidateScaledPositiveBigDecimal {
        // Note all cases for Exceptions were covered in test class TestValidatePositiveBigDecimalAndReturn
        @Test
        public void testValidBigDecimalNumberIsScaledDown() {
            assertEquals(
            BigDecimal.valueOf(3.47),
            ValueValidator.validateAndScalePositiveBigDecimal(
                    BigDecimal.valueOf(3.474),
                    2,
                    "field"
                )
            );
        }

        @Test
        public void testValidBigDecimalNumberIsScaledUp() {
            assertEquals(
                    BigDecimal.valueOf(3.48),
                    ValueValidator.validateAndScalePositiveBigDecimal(
                            BigDecimal.valueOf(3.475),
                            2,
                            "field"
                    )
            );
        }
    }
}
