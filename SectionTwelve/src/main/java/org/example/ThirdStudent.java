package org.example;

import javax.management.Query;
import java.util.List;
import java.util.Objects;

public class ThirdStudent implements QueryItem {

    private String lastName, firstName;
    private String course;
    private int yearStarted;

    public ThirdStudent(String lastName, String firstName, String course, int yearStarted) {
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

    public <T extends ThirdStudent> String printList(List<T> students) {
        // See Generics.md document for the explanation of this method
        // declaration.
        StringBuilder sb = new StringBuilder();
        for (var student : students) {
            sb.append(student.getFirstName()).append(" ")
                .append(student.getLastName()).append("\n");
        }
        return sb.toString().stripTrailing();
    }

    public String printMoreLists(List<? extends ThirdStudent> students) {
        StringBuilder sb = new StringBuilder();
        for (var student : students) {
            sb.append(student.getFirstName()).append(" ")
                .append(student.getLastName()).append("\n");
        }
        return sb.toString().stripTrailing();
    }


    @Override
    public boolean matchFieldValue(String field, String value) {
        String fieldName = field.toUpperCase();
        return switch(fieldName) {
            case "FIRSTNAME" -> this.firstName.equalsIgnoreCase(value);
            case "LASTNAME" -> this.lastName.equalsIgnoreCase(value);
            case "COURSE" -> this.course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> this.yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirdStudent that = (ThirdStudent) o;
        return yearStarted == that.yearStarted &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, course, yearStarted);
    }
}
