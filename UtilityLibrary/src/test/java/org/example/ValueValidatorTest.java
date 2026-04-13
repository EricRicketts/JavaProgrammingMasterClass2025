package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueValidatorTest {

    @Test
    public void testForNegativeInteger() {
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
                () -> ValueValidator.checkForNegativeValue(-10, "Integer is less than zero")
        );
        assertEquals("Integer is less than zero", thrown.getMessage());
    }

    @Test
    public void testForNegativeFloat() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> ValueValidator.checkForNegativeValue(-20.35, "Float is less than zero")
        );
        assertEquals("Float is less than zero", thrown.getMessage());
    }

    @Test
    public void testForNegativeBigDecimal() {
        BigDecimal value = BigDecimal.valueOf(-30.45);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> ValueValidator.checkForNegativeValue(value, "Big Decimal is less than zero")
        );
        assertEquals("Big Decimal is less than zero", thrown.getMessage());
    }

    @Test
    public void testForNull() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> ValueValidator.checkForNull(null, "Null value not allowed")
        );
        assertEquals("Null value not allowed", thrown.getMessage());
    }
}
