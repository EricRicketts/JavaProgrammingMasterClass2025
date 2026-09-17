package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NewStudentTest {

    private NewStudent firstStudent, secondStudent;
    private String name, course;
    private int id, yearStarted;

    @BeforeEach
    public void setUp() {
        firstStudent = new NewStudent(
            "Wile E Coyote",
            "Java",
            112233,
            2012);
        secondStudent = new NewStudent();
        name = "Wile E Coyote";
        course = "Java";
        id = 112233;
        yearStarted = 2012;
    }

    @Nested
    @DisplayName("test New Student Getters")
    class TestNewStudentGetters {

        @Test
        public void testNewStudentGetName() {
            assertEquals(name, firstStudent.getName());
        }

        @Test
        public void testNewStudentGetCourse() {
            assertEquals(course, firstStudent.getCourse());
        }

        @Test
        public void testNewStudentGetId() {
            assertEquals(id, firstStudent.getId());
        }

        @Test
        public void testNewStudentGetYearStarted() {
            assertEquals(yearStarted, firstStudent.getYearStarted());
        }
    }

    @Nested
    @DisplayName("test New Student Setters")
    class TestNewStudentSetters {

        @Test
        public void testNewStudentSetName() {
            assertEquals(name, firstStudent.getName());
            name = "Bugs Bunny";

            firstStudent.setName(name);
            assertEquals(name, firstStudent.getName());
        }

        @Test
        public void testNewStudentSetCourse() {
            assertEquals(course, firstStudent.getCourse());
            course = "Bugs Bunny";

            firstStudent.setCourse(course);
            assertEquals(course, firstStudent.getCourse());
        }

        @Test
        public void testNewStudentSetId() {
            assertEquals(id, firstStudent.getId());
            id = 223344;

            firstStudent.setId(id);
            assertEquals(id, firstStudent.getId());
        }

        @Test
        public void testNewStudentSetYearStarted() {
            assertEquals(yearStarted, firstStudent.getYearStarted());
            yearStarted = 2021;

            firstStudent.setYearStarted(yearStarted);
            assertEquals(yearStarted, firstStudent.getYearStarted());
        }
    }

    @Nested
    @DisplayName("test New Student equals")
    class TestNewStudentEquals {

        @Test
        public void testNewStudentTwoEqualStudents() {
            firstStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);
            secondStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);

            assertEquals(firstStudent, secondStudent);
        }

        @Test
        public void testNewStudentTwoNonEqualStudentsByName() {
            firstStudent = new NewStudent(
                "Porky Pig",
                "Rust",
                123456,
                2011);
            secondStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);

            assertNotEquals(firstStudent, secondStudent);
        }

        @Test
        public void testNewStudentTwoNonEqualStudentsByCourse() {
            firstStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);
            secondStudent = new NewStudent(
                "Yosemite Sam",
                "Python",
                123456,
                2011);

            assertNotEquals(firstStudent, secondStudent);
        }

        @Test
        public void testNewStudentTwoNonEqualStudentsById() {
            firstStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);
            secondStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                987654,
                2011);

            assertNotEquals(firstStudent, secondStudent);
        }

        @Test
        public void testNewStudentTwoNonEqualStudentsByYearStarted() {
            firstStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2012);
            secondStudent = new NewStudent(
                "Yosemite Sam",
                "Rust",
                123456,
                2011);

            assertNotEquals(firstStudent, secondStudent);
        }
    }

    @Nested
    @DisplayName("test New Student HashCode and toString")
    class TestNewStudentHashCodeAndToString {

        @Test
        public void testEqualHashCodes() {
            secondStudent = new NewStudent(
                firstStudent.getName(),
                firstStudent.getCourse(),
                firstStudent.getId(),
                firstStudent.getYearStarted()
            );

            int firstStudentHashCode = firstStudent.hashCode();
            int secondStudentHashCode = secondStudent.hashCode();

            assertEquals(firstStudentHashCode, secondStudentHashCode);
        }

        @Test
        public void testNonEqualHashCodesByName() {
            secondStudent = new NewStudent(
                "Bugs Bunny",
                firstStudent.getCourse(),
                firstStudent.getId(),
                firstStudent.getYearStarted()
            );

            int firstStudentHashCode = firstStudent.hashCode();
            int secondStudentHashCode = secondStudent.hashCode();

            assertNotEquals(firstStudentHashCode, secondStudentHashCode);
        }

        @Test
        public void testNonEqualHashCodesByCourse() {
            secondStudent = new NewStudent(
                firstStudent.getName(),
                "Pascal",
                firstStudent.getId(),
                firstStudent.getYearStarted()
            );

            int firstStudentHashCode = firstStudent.hashCode();
            int secondStudentHashCode = secondStudent.hashCode();

            assertNotEquals(firstStudentHashCode, secondStudentHashCode);
        }
        @Test
        public void testNonEqualHashCodesById() {
            secondStudent = new NewStudent(
                firstStudent.getName(),
                firstStudent.getCourse(),
                871345,
                firstStudent.getYearStarted()
            );

            int firstStudentHashCode = firstStudent.hashCode();
            int secondStudentHashCode = secondStudent.hashCode();

            assertNotEquals(firstStudentHashCode, secondStudentHashCode);
        }
        @Test
        public void testNonEqualHashCodesByYearStarted() {
            secondStudent = new NewStudent(
                firstStudent.getName(),
                firstStudent.getCourse(),
                firstStudent.getId(),
                2002
            );

            int firstStudentHashCode = firstStudent.hashCode();
            int secondStudentHashCode = secondStudent.hashCode();

            assertNotEquals(firstStudentHashCode, secondStudentHashCode);
        }
    }

    @Nested
    @DisplayName("test compare by id")
    class TestCompareById {

        @Test
        public void testCompareToWithSameIds() {
                secondStudent = new NewStudent(
                    firstStudent.getName(),
                    firstStudent.getCourse(),
                    firstStudent.getId(),
                    firstStudent.getYearStarted()
                );

                assertEquals(0, firstStudent.compareTo(secondStudent));
        }

        @Test
        public void testCompareToWithHigherId() {
            // firstStudent has a higher id than secondStudent
            secondStudent = new NewStudent(
                firstStudent.getName(),
                firstStudent.getCourse(),
                111111,
                firstStudent.getYearStarted()
            );

            assertEquals(1, firstStudent.compareTo(secondStudent));
        }

        @Test
        public void testCompareToWithLowerId() {
            // firstStudent has a lower id than secondStudent
            secondStudent = new NewStudent(
                firstStudent.getName(),
                firstStudent.getCourse(),
                333333,
                firstStudent.getYearStarted()
            );

            assertEquals(-1, firstStudent.compareTo(secondStudent));
        }
    }

    @Nested
    @DisplayName("test compare by name")
    class TestCompareByName {

        @Test
        public void testCompareToNameWithGreaterAlphabeticalOrder() {
            secondStudent = new NewStudent(
                "Bugs Bunny",
                firstStudent.getCourse(),
                firstStudent.getId(),
                firstStudent.getYearStarted()
            );

            assertTrue(firstStudent.compareTo(secondStudent) > 0);
        }

        @Test
        public void testCompareToNameWithLowerAlphabeticalOrder() {
            secondStudent = new NewStudent(
                "Zoltan Guy",
                firstStudent.getCourse(),
                firstStudent.getId(),
                firstStudent.getYearStarted()
            );

            assertTrue(firstStudent.compareTo(secondStudent) < 0);
        }
    }
}
