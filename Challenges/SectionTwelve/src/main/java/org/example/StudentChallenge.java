package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class StudentChallenge implements QueryItemChallenge, Comparable<StudentChallenge>  {

    private String name;
    private String course;
    private int yearStarted;
    private int studentId;
    private static Random random = new Random();
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public StudentChallenge() {
        int lastNameIndex = random.nextInt(65, 91); // Capital Letters 'A' to 'Z'.
        this.name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        this.course = courses[random.nextInt(3)];
        this.yearStarted = random.nextInt(2018, 2025);
        this.studentId = random.nextInt(1000, 1999);
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public int getStudentId() {
        return studentId;
    }

    public static String[] getFirstNames() {
        return firstNames;
    }

    public static String[] getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(this.getName(), this.getCourse(), this.getYearStarted());
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String localFieldName = fieldName.toUpperCase();
        return switch (localFieldName) {
            case "STUDENTID" -> this.getStudentId() <= Integer.parseInt(value);
            case "NAME" -> this.getName().split("\\s+")[0].equalsIgnoreCase(value);
            case "COURSE" -> this.getCourse().equalsIgnoreCase(value);
            case "YEARSTARTED" -> this.getYearStarted() == Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;

        StudentChallenge other = (StudentChallenge) object;

        return this.getStudentId() == other.getStudentId() &&
            this.getYearStarted() == other.getYearStarted() &&
            this.getName().equals(other.getName()) &&
            this.getCourse().equals(other.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.getStudentId(), this.getYearStarted(), this.getName(), this.getCourse()
        );
    }

    @Override
    public int compareTo(StudentChallenge other) {
        int compareStudentIds =
            Integer.compare(this.getStudentId(), other.getStudentId());
        if(compareStudentIds != 0) return compareStudentIds;

        int compareStudentYearStarted =
            Integer.compare(this.getYearStarted(), other.getYearStarted());
        if(compareStudentYearStarted != 0) return compareStudentYearStarted;

        int compareStudentName =
            this.getName().compareTo(other.getName());
        if(compareStudentName != 0) return compareStudentName;

        return this.getCourse().compareTo(other.getCourse());
    }
}
