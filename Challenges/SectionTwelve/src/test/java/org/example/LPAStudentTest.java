package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LPAStudentTest {

    private LPAStudent lpaStudent;

    @BeforeEach
    public void setUp() {
        lpaStudent = new LPAStudent();
    }

    @Test
    public void testLPAStudentName() {
        String lpaStudentName = lpaStudent.getName();
        String[] firstNameAndLastNameInitial = lpaStudentName.split(" ");
        String firstName = firstNameAndLastNameInitial[0];
        String lastNameInitial = firstNameAndLastNameInitial[1];

        assertTrue(Arrays.asList(ThirdStudent.getFirstNames()).contains(firstName));
        assertTrue(Character.isUpperCase(lastNameInitial.charAt(0)));
    }

    @Test
    public void testLPAStudentCourse() {
        String lpaStudentCourse = lpaStudent.getCourse();

        assertTrue(Arrays.asList(ThirdStudent.getCourses()).contains(lpaStudentCourse));
    }

    @Test
    public void testLPAStudentYearStartedCourse() {
        int studentYearStartedCourse = lpaStudent.getYearStarted();

        assertTrue(studentYearStartedCourse >= 2018 && studentYearStartedCourse <= 2025);
    }
}
