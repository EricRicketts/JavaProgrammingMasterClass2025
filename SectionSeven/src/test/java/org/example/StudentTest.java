package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    ArrayList<Student> students = new ArrayList<Student>();
    String expected, result;

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            Student s = new Student("S92300" + i,
                    switch (i) {
                        case 0 -> "Mary";
                        case 1 -> "Carol";
                        case 2 -> "Tim";
                        case 3 -> "Harry";
                        case 4 -> "Lisa";
                        default -> "Anonymous";
                    },
                    switch (i) {
                        case 0 -> "1/1/1985";
                        case 1 -> "2/1/1985";
                        case 2 -> "3/1/1985";
                        case 3 -> "4/1/1985";
                        case 4 -> "5/1/1985";
                        default -> "Default Birth Date";
                    },
                    "Java Masterclass"
            );
            students.add(s);
        }
    }

    @Test
    public void testStudentPOJOs() {
        assertEquals(5, students.size());
    }

    @Test
    public void testToStringOnThirdStudent() {
        expected =
                "Student{id='S923002', name='Tim', dateOfBirth='3/1/1985'," +
                        " classList='Java Masterclass'}";
        result = students.get(2).toString();
        assertEquals(expected, result);
    }

    @Test
    public void testOneGetterAndSetterOnFirstStudent() {
        expected = "1/1/1985";
        result = students.getFirst().getDateOfBirth();
        assertEquals(expected, result);
        students.getFirst().setDateOfBirth("6/1/1985");
        expected = "6/1/1985";
        result = students.getFirst().getDateOfBirth();
        assertEquals(expected, result);
    }
}
