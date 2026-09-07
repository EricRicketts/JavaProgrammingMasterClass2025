package org.example;

import java.util.Random;

public class SecondStudent {

    private String lastName, firstName;
    private String course;
    private int yearStarted;

    public SecondStudent(String lastName, String firstName, String course, int yearStarted) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.yearStarted = yearStarted;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" + "{\n" +
            "lastName='" + lastName + '\'' + ",\n" +
            "firstName='" + firstName + '\'' + ",\n" +
            "course='" + course + '\'' + ",\n" +
            "yearStarted='" + yearStarted + '\'' + ",\n" +
            '}';
    }
}
