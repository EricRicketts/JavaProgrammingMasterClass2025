package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueValidatorTest {

    @Nested
    @DisplayName("zero value checks")
    class ZeroValueChecks {

        @Test
        public void testIntegerZeroValue() {
            assertEquals(
                    "Integer zero is not allowed",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.checkForZeroValueAndReturn(
                                    0,
                                    "Integer zero is not allowed")
                    ).getMessage()
            );
        }

       @Test
        public void testBigDecimalZeroValue() {
            assertEquals(
                    "BigDecimal zero is not allowed",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.checkForZeroValueAndReturn(
                                    BigDecimal.valueOf(0.00),
                                    "BigDecimal zero is not allowed")
                    ).getMessage()
            );
        }

        @Test
        public void testIntegerNonZeroValue() {
            assertEquals(
                    1,
                    ValueValidator.checkForZeroValueAndReturn(
                    1,
                    "Integer zero is not allowed")
            );
        }

        @Test
        public void testBigDecimalNonZeroValue() {
            assertEquals(
                    BigDecimal.valueOf(10.87),
                    ValueValidator.checkForZeroValueAndReturn(
                            BigDecimal.valueOf(10.87),
                            "BigDecimal zero is not allowed"
                    )
            );
        }
    }

    @Nested
    @DisplayName("Negative value checks")
    class NegativeValueChecks {

        @Test
        public void testNegativeInteger() {
            IllegalArgumentException thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> ValueValidator.checkForNegativeValueAndReturn(
                            -10,
                            "Negative integer is not allowed")
            );
            assertEquals("Negative integer is not allowed", thrown.getMessage());
        }

        @Test
        public void testNegativeBigDecimal() {
            IllegalArgumentException thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> ValueValidator.checkForNegativeValueAndReturn(
                            BigDecimal.valueOf(-30.45),
                            "Negative BigDecimal is not allowed")
            );
            assertEquals("Negative BigDecimal is not allowed", thrown.getMessage());
        }

        @Test
        public void testNonNegativeInteger() {
            assertEquals(
                    5,
                    ValueValidator.checkForNegativeValueAndReturn(
                            5,
                            "Negative integer is not allowed")
            );
        }
    }

        @Test
        public void testForNull() {
            NullPointerException thrown = assertThrows(
                    NullPointerException.class,
                    () -> ValueValidator.checkForNullValueAndReturn(null, "Null value not allowed")
            );
            assertEquals("Null value not allowed", thrown.getMessage());
        }
}
