package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentInfoTest {

    private final String name = "Elmer Fudd";
    private final int id = 123456;
    private final BigDecimal gpa = BigDecimal.valueOf(2.55);

    @Nested
    @DisplayName("constructor checks for name")
    class NameConstructorChecks {

        @Test
        public void testConstructorRejectsNullName() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new StudentInfo(null, id, gpa)
                    ).getMessage()
            );
        }
    }
}
