package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondStudentTest {

    private SecondStudent secondStudent;
    private static Random random = new Random();
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] lastNames = {"Abel", "Baker", "Cusp", "Danger", "Echo"};
    private static String[] courses = {"C++", "Java", "Python", "Javascript", "C"};
    private static Integer[] yearsStarted = {2021, 2022, 2023, 2024, 2025};

    SecondStudent student;

    @BeforeEach
    public void setUp() {
        student = new SecondStudent(
            "Flintstone", "Fred", "Rust", 2222);
    }

    @Nested
    @DisplayName("test second student getters")
    class TestSecondStudentGetters {

        @Test
        public void testSecondStudentGetLastname() {
            assertEquals("Flintstone", student.getLastName());
        }

        @Test
        public void testSecondStudentGetFirstname() {
            assertEquals("Fred", student.getFirstName());
        }

        @Test
        public void testSecondStudentGetCourse() {
            assertEquals("Rust", student.getCourse());
        }

        @Test
        public void testSecondStudentGetYearStarted() {
            assertEquals(2222, student.getYearStarted());
        }
    }

    @Nested
    @DisplayName("test second student setters")
    class TestSecondStudentSetters {

        @Test
        public void testSecondStudentSetLastname() {
            assertEquals("Flintstone", student.getLastName());
            student.setLastName("Rubble");

            assertEquals("Rubble", student.getLastName());
        }

        @Test
        public void testSecondStudentSetFirstname() {
            assertEquals("Fred", student.getFirstName());
            student.setFirstName("Barney");

            assertEquals("Barney", student.getFirstName());
        }

        @Test
        public void testSecondStudentSetCourse() {
            assertEquals("Rust", student.getCourse());
            student.setCourse("Kotlin");

            assertEquals("Kotlin", student.getCourse());
        }

        @Test
        public void testSecondStudentSetYearStarted() {
            assertEquals(2222, student.getYearStarted());
            student.setYearStarted(3333);

            assertEquals(3333, student.getYearStarted());
        }
    }

    @Nested
    @DisplayName("test student toString")
    class TestStudentToString {

        @Test
        public void testStudentToString() {
            String expected = "SecondStudent:\n" +
                "{\n" +
                "lastName='Flintstone',\n" +
                "firstName='Fred',\n" +
                "course='Rust',\n" +
                "yearStarted='2222',\n" +
                "}";
            String result = student.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test second student print list")
    class TestSecondStudentPrintList {

        @Test
        public void testSecondStudentPrintList() {
            // Note the argument for printList() can be either
            // SecondStudent or LPAStudent.
            SecondStudent firstStudent = new SecondStudent(
                "Flintstone", "Fred",
                "Java", 2021);
            SecondStudent secondStudent = new SecondStudent(
                "Rubble", "Barney",
                "C++", 2022);
            List<SecondStudent> students = new ArrayList<>(List.of(
                firstStudent, secondStudent
            ));

            String expected = "Fred Flintstone\n" + "Barney Rubble";
            String result = student.printList(students);

            assertEquals(expected, result);

            result = student.printMoreLists(students);
            assertEquals(expected, result);
        }
    }
}
