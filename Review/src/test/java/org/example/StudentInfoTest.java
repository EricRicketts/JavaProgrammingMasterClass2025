package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentInfoTest {

    private StudentInfo studentInfo;
    private final String name = "Elmer Fudd";
    private final int id = 123456;
    private final BigDecimal gpa = BigDecimal.valueOf(2.55);

    @BeforeEach
    public void setUp() {
        studentInfo = new StudentInfo(name, id, gpa);
    }

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

        @Test
        public void testConstructorRejectsEmptyName() {
            assertEquals(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo("", id, gpa)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankName() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo("  ", id, gpa)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("constructor checks for id")
    class IDConstructorChecks {

        @Test
        public void testConstructorRejectsZeroID() {
            assertEquals(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo(name, 0, gpa)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNegativeID() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo(name, -34, gpa)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("constructor checks for gpa")
    class GPAConstructorChecks {

        @Test
        public void testConstructorRejectsNullGPA() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_GPA.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new StudentInfo(name, id, null)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsZeroGPA() {
            assertEquals(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_GPA.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo(name, id, BigDecimal.ZERO)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNegativeGPA() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_GPA.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new StudentInfo(name, id, new BigDecimal("-2.45"))
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("getter checks")
    class GetterChecks {

        @Test
        public void testGetName() {
            assertEquals(
                    name,
                    studentInfo.getName()
            );
        }

        @Test
        public void testGetID() {
            assertEquals(
                    id,
                    studentInfo.getID()
            );
        }

        @Test
        public void testGetGPA() {
            assertEquals(
                    gpa,
                    studentInfo.getGPA()
            );
        }
    }
}
