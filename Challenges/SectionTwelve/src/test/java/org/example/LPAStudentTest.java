package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testGetCoursePercentComplete() {
        int firstComparisonResult = lpaStudent.getPercentComplete().compareTo(new BigDecimal("0.00"));
        assertTrue(firstComparisonResult == 0 || firstComparisonResult > 0);

        int secondComparisonResult = lpaStudent.getPercentComplete().compareTo(new BigDecimal("100.001"));
        assertTrue(secondComparisonResult < 0);
    }

    @Test
    public void testSetCourseComplete() {
        BigDecimal percentComplete = new BigDecimal("45.67");
        lpaStudent.setPercentComplete(percentComplete);

        assertEquals(percentComplete, lpaStudent.getPercentComplete());
    }

    @Test
    public void testPercentCompleteInToString() {
        String LPAStudentString = lpaStudent.toString();
        String[] LPAStudentSplitString = LPAStudentString.split("\\s+");
        int lengthOfString = LPAStudentSplitString.length;
        String percentCompleteStringWithPercentageSymbol = LPAStudentSplitString[lengthOfString - 1];
        String percentCompleteString = percentCompleteStringWithPercentageSymbol.substring(0, lengthOfString - 1);
        double percentComplete = Double.parseDouble(percentCompleteString);
        assertTrue(percentComplete >= 0.00 && percentComplete <= 100.00);
    }

    @Test
    public void testPrintMoreLists() {
        ThirdStudent thirdStudent = new ThirdStudent();
        // I can do this because LPAStudent is a subtype of Student.
        List<ThirdStudent> students = new ArrayList<>(List.of(thirdStudent, lpaStudent));
        String printStudents = LPAStudent.printMoreLists(students);

        String[] studentData = printStudents.split("\\s+");

        // Limited checking on this method test as the prior testing has verified the methods on ThirdStudent and
        // LPAStudent.
        
        String firstName = studentData[1];
        assertTrue(Arrays.asList(LPAStudent.getFirstNames()).contains(firstName));

        String getPercentComplete = studentData[studentData.length - 1];
        assertTrue(getPercentComplete.contains("%"));
    }
}
