package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondStudentTest {

    SecondStudent firstStudent, secondStudent, thirdStudent;
    SecondStudent[] students;

    @BeforeEach
    public void setUp() {
        firstStudent = new SecondStudent("Alice", 667788, new BigDecimal("3.24"));
        secondStudent = new SecondStudent("Bob", 889911, new BigDecimal("3.25"));
        thirdStudent = new SecondStudent("Charlie", 778899, new BigDecimal("3.26"));
        students = new SecondStudent[]{firstStudent, secondStudent, thirdStudent};
    }

    @Test
    public void testDefaultSortIsByGPA() {
        SecondStudent[] expectedSort = new SecondStudent[]{thirdStudent, secondStudent, firstStudent};
        Comparator<SecondStudent> gpaComparator = new StudentGPAComparator();
        Arrays.sort(students, gpaComparator.reversed());

        assertArrayEquals(expectedSort, students);
    }

    @Test
    public void testIfGPAsEqualSortByName() {
        secondStudent.setGpa(new BigDecimal("3.24"));
        thirdStudent.setGpa(new BigDecimal("3.24"));
        SecondStudent[] expectedSort = new SecondStudent[]{
            firstStudent, secondStudent, thirdStudent
        };

        students = new SecondStudent[]{thirdStudent, firstStudent, secondStudent};

        Comparator<SecondStudent> gpaComparator = new StudentGPAComparator();
        Arrays.sort(students, gpaComparator);

        assertArrayEquals(expectedSort, students);
    }

    @Test
    public void testIfGPAsEqualSortById() {
        firstStudent.setName("Ken");
        secondStudent.setName("Ken");
        thirdStudent.setName("Ken");

        secondStudent.setGpa(new BigDecimal("3.24"));
        thirdStudent.setGpa(new BigDecimal("3.24"));
        SecondStudent[] expectedSort = new SecondStudent[]{
            secondStudent, thirdStudent, firstStudent
        };

        students = new SecondStudent[]{firstStudent, secondStudent, thirdStudent};

        Comparator<SecondStudent> gpaComparator = new StudentGPAComparator();
        Arrays.sort(students, gpaComparator.reversed());

        assertArrayEquals(expectedSort, students);
    }
}
