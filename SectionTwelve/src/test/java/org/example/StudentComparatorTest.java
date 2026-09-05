package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentComparatorTest {

    @Nested
    @DisplayName("test Student GPA comparator")
    class TestStudentComparator {

        private Student student, secondStudent;
        private StudentComparator studentComparator;

        @BeforeEach
        public void setUp() {
            student = new Student("Fudd", "Elmer");
            studentComparator = new StudentComparator();
        }

        @Test
        public void testCompareStudentLastNames() {
            secondStudent = new Student("Bunny", "Bugs");
            assertTrue(studentComparator.compare(student, secondStudent) > 0);

            secondStudent = new Student("Leghorn", "Foghorn");
            assertTrue(studentComparator.compare(student, secondStudent) < 0);
        }

        @Test
        public void testCompareStudentFirstNames() {
            secondStudent = new Student("Fudd", "Able");
            assertTrue(studentComparator.compare(student, secondStudent) > 0);

            secondStudent = new Student("Fudd", "Myron");
            assertTrue(studentComparator.compare(student, secondStudent) < 0);
        }

        @Test
        public void testCompareStudentIds() {
            secondStudent = new Student("Fudd", "Elmer");
            student.setId(1002);
            secondStudent.setId(1001);
            assertTrue(studentComparator.compare(student, secondStudent) > 0);

            student.setId(1001);
            secondStudent.setId(1002);
            assertTrue(studentComparator.compare(student, secondStudent) < 0);
        }

        @Test
        public void testCompareStudentGPAs() {
            student.setId(1005);
            secondStudent = new Student("Fudd", "Elmer");
            secondStudent.setId(1005);

            student.setGpa(new BigDecimal("2.43"));
            secondStudent.setGpa(new BigDecimal("2.08"));
            assertTrue(studentComparator.compare(student, secondStudent) > 0);

            student.setGpa(new BigDecimal("2.08"));
            secondStudent.setGpa(new BigDecimal("2.43"));
            assertTrue(studentComparator.compare(student, secondStudent) < 0);
        }
    }
}
