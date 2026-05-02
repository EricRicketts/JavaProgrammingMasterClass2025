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
        public void testForIntegerZeroValue() {
            assertEquals(
                    "Integer zero not allowed",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.checkForZeroValueAndReturn(
                                    0,
                                    "Integer zero not allowed")
                    ).getMessage()
            );
        }

       @Test
        public void testForBigDecimalZeroValue() {
            assertEquals(
                    "BigDecimal zero not allowed",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> ValueValidator.checkForZeroValueAndReturn(
                                    BigDecimal.valueOf(0.00),
                                    "BigDecimal zero not allowed")
                    ).getMessage()
            );
        }

    }

    @Test
    public void testForNegativeInteger() {
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
                () -> ValueValidator.checkForNegativeValueAndReturn(-10, "Integer is less than zero")
        );
        assertEquals("Integer is less than zero", thrown.getMessage());
    }

    @Test
    public void testForNegativeBigDecimal() {
        BigDecimal value = BigDecimal.valueOf(-30.45);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> ValueValidator.checkForNegativeValueAndReturn(value, "Big Decimal is less than zero")
        );
        assertEquals("Big Decimal is less than zero", thrown.getMessage());
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
