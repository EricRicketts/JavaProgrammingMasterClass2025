package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void testStudentNames() {
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
    public void testStudentCourses() {
        for (ThirdStudent student : students) {
            String studentCourse = student.getCourse();

            assertTrue(Arrays.asList(ThirdStudent.getCourses()).contains(studentCourse));
        }
    }

    @Test
    public void testStudentYearStartedCourse() {
        for (ThirdStudent student : students) {
            int studentYearStartedCourse = student.getYearStarted();

            assertTrue(studentYearStartedCourse >= 2018 && studentYearStartedCourse <= 2025);
        }
    }
}
