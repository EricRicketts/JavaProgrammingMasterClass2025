package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewStudentTest {

    private NewStudent firstStudent, secondStudent;
    private String name, course;
    private int id, yearStarted;

    @BeforeEach
    public void setUp() {
        firstStudent = new NewStudent("Wile E Coyote", "Java", 112233, 2012);
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
}
