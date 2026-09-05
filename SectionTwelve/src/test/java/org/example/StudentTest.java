package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student, secondStudent;

    @BeforeEach
    public void setUp() {
        student = new Student("Fudd", "Elmer");
    }

    @Nested
    @DisplayName("test student getters")
    class TestStudentGetters {

        @Test
        public void testGetStudentLastName() {
            assertEquals("Fudd", student.getLastName());
        }

        @Test
        public void testGetStudentFirstName() {
            assertEquals("Elmer", student.getFirstName());
        }

        @Test
        public void testGetStudentId() {
            assertEquals(1000, student.getId());
        }

        @Test
        public void testGetStudentGpa() {
            int gpaCompareUpperBound = student.getGpa().compareTo(new BigDecimal("4.00"));
            assertTrue(gpaCompareUpperBound <= 0);

            int gpaCompareLowerBound = student.getGpa().compareTo(new BigDecimal("1.00"));
            assertTrue(gpaCompareLowerBound >= 0);
        }
    }

    @Nested
    @DisplayName("test set student gpa")
    class TestSetStudentGpa {

        @Test
        public void testSetStudentGpa() {
            assertNotEquals(new BigDecimal("2.24"), student.getGpa());

            student.setGpa(new BigDecimal("2.24"));
            assertEquals(new BigDecimal("2.24"), student.getGpa());
        }
    }

    @Nested
    @DisplayName("compare students using Comparable")
    class TestCompareStudentsUsingComparable {

        @Test
        public void testCompareStudentLastNames() {
            secondStudent = new Student("Bunny", "Bugs");
            assertTrue(student.compareTo(secondStudent) > 0);

            secondStudent = new Student("Leghorn", "Foghorn");
            assertTrue(student.compareTo(secondStudent) < 0);
        }

        @Test
        public void testCompareStudentFirstNames() {
            secondStudent = new Student("Fudd", "Able");
            assertTrue(student.compareTo(secondStudent) > 0);

            secondStudent = new Student("Fudd", "Myron");
            assertTrue(student.compareTo(secondStudent) < 0);
        }

        @Test
        public void testCompareStudentIds() {
            secondStudent = new Student("Fudd", "Elmer");
            student.setId(1002);
            secondStudent.setId(1001);
            assertTrue(student.compareTo(secondStudent) > 0);

            student.setId(1001);
            secondStudent.setId(1002);
            assertTrue(student.compareTo(secondStudent) < 0);
        }

        @Test
        public void testCompareStudentGPAs() {
            student.setId(1005);
            secondStudent = new Student("Fudd", "Elmer");
            secondStudent.setId(1005);

            student.setGpa(new BigDecimal("2.43"));
            secondStudent.setGpa(new BigDecimal("2.08"));
            assertTrue(student.compareTo(secondStudent) > 0);

            student.setGpa(new BigDecimal("2.08"));
            secondStudent.setGpa(new BigDecimal("2.43"));
            assertTrue(student.compareTo(secondStudent) < 0);
        }
    }
}
