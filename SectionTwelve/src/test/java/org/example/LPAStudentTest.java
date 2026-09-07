package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LPAStudentTest {
    /*
        Some important commentary from the video lectures.
        Student           List<Student>          ArrayList<Student>
           ^                   ^                         ^
           |                   |                         |
           |                   |                         X
           |                   |                         |
       Inheritance        Interface Implementation   NOT INHERITANCE!!
        LPA Student        ArrayList<Student>       ArrayList<LPAStudent>

       Clearly, since LPAStudent inherits from Student, we can pass any
       instance of LPAStudent to any method or assign it to any reference
       type, declared with type Student.

        We also know ArrayList implements List, and we can pass an ArrayList
        to a method or assign it to a reference of List Type, we saw this in
        both cases for our Student ArrayList.

        But we cannot pass an ArrayList of LPAStudent to a method parameter
        that is declared as a List of Student?  It is natural to assume since
        an LPAStudent is a Student, we should be able to pass a List of LPAStudents
        to a List of Students.

        However, when used as reference types, a container of one type has no
        relationship to the same container of another type, even if the contained
        types do have a relationship.

        For instance, with the following method signature:
        public static void (List<Student> student) we cannot past a List<LPAStudent>
        as an argument to the method.

        The following code also yields a compiler error:
        List<Student> students = new ArrayList<LPAStudent>();

        In the second case above, the container type reference is Student, and as such
        it only allows a Student type; the same holds for the first example in the
        method argument.
    */

    @Nested
    @DisplayName("test second student getters and setters")
    class TestLPAStudentGettersAndSetters {

        LPAStudent student;
        @BeforeEach
        public void setUp() {
            student = new LPAStudent(
                "Flintstone", "Fred", "Rust", 2222);
        }

        @Nested
        @DisplayName("test second student getters")
        class TestLPAStudentGetters {

            @Test
            public void testLPAStudentGetLastname() {
                assertEquals("Flintstone", student.getLastName());
            }

            @Test
            public void testLPAStudentGetFirstname() {
                assertEquals("Fred", student.getFirstName());
            }

            @Test
            public void testLPAStudentGetCourse() {
                assertEquals("Rust", student.getCourse());
            }

            @Test
            public void testLPAStudentGetYearStarted() {
                assertEquals(2222, student.getYearStarted());
            }

            @Test
            public void testLPAStudentGetPercentComplete() {
                BigDecimal percentComplete = student.getPercentComplete();
                assertTrue(
                    percentComplete.compareTo(BigDecimal.ZERO) >= 0
                        &&
                        percentComplete.compareTo(new BigDecimal("100.001")) <= 0
                );
            }
        }

        @Nested
        @DisplayName("test second student setters")
        class TestLPAStudentSetters {

            @Test
            public void testLPAStudentSetLastname() {
                assertEquals("Flintstone", student.getLastName());
                student.setLastName("Rubble");

                assertEquals("Rubble", student.getLastName());
            }

            @Test
            public void testLPAStudentSetFirstname() {
                assertEquals("Fred", student.getFirstName());
                student.setFirstName("Barney");

                assertEquals("Barney", student.getFirstName());
            }

            @Test
            public void testLPAStudentSetCourse() {
                assertEquals("Rust", student.getCourse());
                student.setCourse("Kotlin");

                assertEquals("Kotlin", student.getCourse());
            }

            @Test
            public void testLPAStudentSetYearStarted() {
                assertEquals(2222, student.getYearStarted());
                student.setYearStarted(3333);

                assertEquals(3333, student.getYearStarted());
            }

            @Test
            public void testLPAStudentSetPercentComplete() {
                BigDecimal percentComplete = student.getPercentComplete();
                assertTrue(
                    percentComplete.compareTo(BigDecimal.ZERO) >= 0
                        &&
                        percentComplete.compareTo(new BigDecimal("100.001")) <= 0
                );
                student.setPercentComplete(new BigDecimal("55.45"));

                assertEquals(new BigDecimal("55.45"), student.getPercentComplete());
            }
        }

        @Nested
        @DisplayName("test student toString")
        class TestStudentToString {

            @Test
            public void testStudentToString() {
                String expected = "LPAStudent:\n" +
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
    }
}
