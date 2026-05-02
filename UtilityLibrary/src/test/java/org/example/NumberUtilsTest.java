package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {

    @Nested
    @DisplayName("Scaling rounds correctly rounds down or up")
    class SetScaleRounding {

        @Test
        public void testSetScaleLower() {
            BigDecimal expected = BigDecimal.valueOf(35.12);
            BigDecimal actual = NumberUtils.setScale(BigDecimal.valueOf(35.1243), 2);
            assertEquals(0, expected.compareTo(actual));
        }

        @Test
        public void testSetScaleHigher() {
            BigDecimal expected = BigDecimal.valueOf(35.13);
            BigDecimal actual = NumberUtils.setScale(BigDecimal.valueOf(35.1254), 2);
            assertEquals(0, expected.compareTo(actual));
        }
    }
}
