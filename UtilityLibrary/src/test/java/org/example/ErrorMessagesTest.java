package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMessagesTest {

    @Nested
    @DisplayName("test all error messages")
    class TestErrorMessages {

        @Test
        public void testNullValueMessage() {
            assertEquals(
                    ErrorMessages.nullValue("") + "field",
                    ErrorMessages.nullValue("field")
            );
        }

        @Test
        public void testEmptyValueMessage() {
            assertEquals(
                    ErrorMessages.emptyValue("") + "field",
                    ErrorMessages.emptyValue("field")
            );
        }

        @Test
        public void testBlankValueMessage() {
            assertEquals(
                    ErrorMessages.blankValue("") + "field",
                    ErrorMessages.blankValue("field")
            );
        }

        @Test
        public void testZeroValueMessage() {
            assertEquals(
                    ErrorMessages.zeroValue("") + "field",
                    ErrorMessages.zeroValue("field")
            );
        }

        @Test
        public void testNegativeValueMessage() {
            assertEquals(
                    ErrorMessages.negativeValue("") + "field",
                    ErrorMessages.negativeValue("field")
            );
        }
    }
}
