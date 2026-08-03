package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    private Student student;
    private Student[] students;

    @BeforeEach
    public void setUp() {
        student = new Student("Cain", 123456);
        students = new Student[]{
            new Student("Bill", 102345),
            new Student("Cain", 123457),
            new Student("Douglas", 101001)
        };
    }

    @Test
    public void testStudentToString() {
        String expected = "Student name is Cain.  Student id is 123456.";
        String result = student.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testCompareToStudentWithLesserName() {
        int compareResult = student.compareTo(students[0]);
        int expectedResult = 1;

        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void testCompareToStudentWithSameName() {
        // Result will be from id compare.
        int compareResult = student.compareTo(students[1]);
        int expectedResult = -1;

        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void testCompareToStudentWithGreaterName() {
        int compareResult = student.compareTo(students[2]);
        int expectedResult = -1;

        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void testSortStudents() {
        Student[] unsortedStudents = new Student[]{students[2], students[1], students[0]};
        Arrays.sort(unsortedStudents);

        assertArrayEquals(students, unsortedStudents);
    }
}
