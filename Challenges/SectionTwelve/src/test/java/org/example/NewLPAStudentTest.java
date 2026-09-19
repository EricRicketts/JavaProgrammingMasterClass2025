package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class NewLPAStudentTest {
   /*
        All the functionality inherited by NewLPAStudent from NewStudent has been tested
        in the NewStudentTest file.  This file will only test the fields and methods
        unique to NewLPAStudent.
   */
    private NewLPAStudent firstLPAStudent, secondLPAStudent;
    private BigDecimal lowerBound, upperBound;

    @BeforeEach
    public void setUp() {
        firstLPAStudent = new NewLPAStudent(
            "Vincent Diorio",
            "Javascript",
            110022,
            2001
            );
        secondLPAStudent = new NewLPAStudent();
        lowerBound = new BigDecimal("0.00")
            .setScale(2, RoundingMode.HALF_UP);
        upperBound = new BigDecimal("100.00")
            .setScale(2, RoundingMode.HALF_UP);
    }

    @Nested
    @DisplayName("test percent complete getter and setter")
    class TestPercentCompleteGetterAndSetter {

        @Test
        public void testGetPercentComplete() {
            BigDecimal percentComplete = firstLPAStudent.getPercentComplete();

            assertTrue(percentComplete.compareTo(lowerBound) >= 0);
            assertTrue(percentComplete.compareTo(upperBound) <= 0);
        }

        @Test
        public void testSetPercentComplete() {
            BigDecimal percentComplete = firstLPAStudent.getPercentComplete();

            assertTrue(percentComplete.compareTo(lowerBound) >= 0);
            assertTrue(percentComplete.compareTo(upperBound) <= 0);

            BigDecimal value = new BigDecimal("34.56")
                .setScale(2, RoundingMode.HALF_UP);
            firstLPAStudent.setPercentComplete(value);

            assertEquals(value, firstLPAStudent.getPercentComplete());
        }
    }

    @Nested
    @DisplayName("test match field value for NewLPAStudent")
    class TestMatchFieldValueForNewLPAStudent {

        @Test
        public void testPercentCompleteMatchFieldValueTrue() {
            BigDecimal value = firstLPAStudent.getPercentComplete();
            assertTrue(
                firstLPAStudent.matchFieldValue(
                    "percentComplete",
                    String.valueOf(value))
            );
        }

        @Test
        public void testPercentCompleteMatchFieldValueFalse() {
            BigDecimal value = firstLPAStudent.getPercentComplete();
            BigDecimal margin = new BigDecimal("1.00")
                .setScale(2, RoundingMode.HALF_UP);
            if ((value.subtract(lowerBound)).compareTo(margin) <= 0) {
                BigDecimal adder = new BigDecimal("49.55")
                    .setScale(2, RoundingMode.HALF_UP);
                value = value.add(adder);
            } else if ((upperBound.subtract(value)).compareTo(margin) >= 0) {
                BigDecimal subtractor = new BigDecimal("49.55")
                    .setScale(2, RoundingMode.HALF_UP);
                value = value.subtract(subtractor);
            } else {
                value = value.add(new BigDecimal("0.01"))
                    .setScale(2, RoundingMode.HALF_UP);
            }
            assertFalse(
                firstLPAStudent.matchFieldValue(
                    "percentComplete",
                    String.valueOf(value))
            );
        }
    }

    @Nested
    @DisplayName("test NewLPAStudent equals and hash code")
    class TestNewLPAStudentEqualsAndHashCode {

        private BigDecimal value;
        private NewLPAStudent firstLPAStudent, secondLPAStudent;

        @BeforeEach
        public void setUp() {
            BigDecimal value = new BigDecimal("45.66")
                .setScale(2, RoundingMode.HALF_UP);
            firstLPAStudent = new NewLPAStudent(
                "Elmer Fudd",
                "Java",
                112233,
                2014
            );
            secondLPAStudent = new NewLPAStudent(
                "Elmer Fudd",
                "Java",
                112233,
                2014
            );
        }

        @Test
        public void testEqualNewLPAStudents() {
            firstLPAStudent.setPercentComplete(value);
            secondLPAStudent.setPercentComplete(value);

            assertEquals(firstLPAStudent, secondLPAStudent);
        }

        @Test
        public void testNonEqualNewLPAStudents() {
            firstLPAStudent.setPercentComplete(value);
            value = new BigDecimal("35.66")
                .setScale(2, RoundingMode.HALF_UP);
            secondLPAStudent.setPercentComplete(value);

            assertNotEquals(firstLPAStudent, secondLPAStudent);
        }

        @Test
        public void testEqualHashCodesForNewLPAStudents() {

            firstLPAStudent.setPercentComplete(value);
            secondLPAStudent.setPercentComplete(value);
            int firstHashCode = firstLPAStudent.hashCode();
            int secondHashCode = secondLPAStudent.hashCode();

            assertEquals(firstHashCode, secondHashCode);
        }

        @Test
        public void testNonEqualHashCodesForNewLPAStudents() {

            firstLPAStudent.setPercentComplete(value);
            secondLPAStudent.setPercentComplete(new BigDecimal("50.55"));
            int firstHashCode = firstLPAStudent.hashCode();
            int secondHashCode = secondLPAStudent.hashCode();

            assertNotEquals(firstHashCode, secondHashCode);
        }
    }
}
