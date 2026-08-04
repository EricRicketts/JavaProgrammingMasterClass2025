package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThirdStudentTest {

    List<ThirdStudent> students = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        for (int index = 0; index < 9; index+=1) {
            students.add(new ThirdStudent());
        }
    }

    @Test
    public void testThirdStudentNames() {
        for (ThirdStudent student : students) {
            String studentName = student.getName();
            String[] firstNameAndLastNameInitial = studentName.split(" ");
            String firstName = firstNameAndLastNameInitial[0];
            String lastNameInitial = firstNameAndLastNameInitial[1];

            assertTrue(Arrays.asList(ThirdStudent.getFirstNames()).contains(firstName));
            assertTrue(Character.isUpperCase(lastNameInitial.charAt(0)));
        }
    }

    @Test
    public void testThirdStudentCourses() {
        for (ThirdStudent student : students) {
            String studentCourse = student.getCourse();

            assertTrue(Arrays.asList(ThirdStudent.getCourses()).contains(studentCourse));
        }
    }

    @Test
    public void testThirdStudentYearStartedCourse() {
        for (ThirdStudent student : students) {
            int studentYearStartedCourse = student.getYearStarted();

            assertTrue(studentYearStartedCourse >= 2018 && studentYearStartedCourse <= 2025);
        }
    }

    @Test
    public void testThirdStudentToString() {
        ThirdStudent selectedThirdStudent = students.getFirst();
        String result = selectedThirdStudent.toString();
        String[] splitStringForThirdStudent = result.splitWithDelimiters("\\s+", 0);
        String firstName = splitStringForThirdStudent[0];
        String firstSetOfSpaces = splitStringForThirdStudent[1];
        String lastNameInitial = splitStringForThirdStudent[2];
        String secondSetOfSpaces = splitStringForThirdStudent[3];
        int numberOfSpacesForSecondSetOfSpaces = secondSetOfSpaces.length();
        String course = splitStringForThirdStudent[4];
        String thirdSetOfSpaces = splitStringForThirdStudent[5];
        int numberOfSpacesForThirdSetOfSpaces = thirdSetOfSpaces.length();
        String yearStartedString = splitStringForThirdStudent[6];
        int yearStarted = Integer.parseInt(yearStartedString);


        Font font = new Font("JetBrainsMono-Regular", Font.PLAIN, 13);
        Canvas canvas = new Canvas();
        FontMetrics fm = canvas.getFontMetrics(font);
        int charWidthForPlus = fm.charWidth('+');
        int charWidthForCapitalA = fm.charWidth('A');

        assertTrue(charWidthForPlus > charWidthForCapitalA);
        assertTrue(Arrays.asList(ThirdStudent.getFirstNames()).contains(firstName));
        assertEquals(1, firstSetOfSpaces.length());
        assertTrue(Character.isUpperCase(lastNameInitial.charAt(0)));
        assertTrue(numberOfSpacesForSecondSetOfSpaces >= 8 &&
            numberOfSpacesForSecondSetOfSpaces <= 12);
        assertTrue(Arrays.asList(ThirdStudent.getCourses()).contains(course));
        assertTrue(numberOfSpacesForThirdSetOfSpaces >= 8 &&
            numberOfSpacesForThirdSetOfSpaces <= 13);
        assertTrue(yearStarted >= 2018 && yearStarted <= 2025);
    }
}
