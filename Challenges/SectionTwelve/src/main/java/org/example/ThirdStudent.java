package org.example;

import java.util.Random;

public class ThirdStudent {

    private String name;
    private String course;
    private int yearStarted;
    private static Random random = new Random();
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public ThirdStudent() {
        int lastNameIndex = random.nextInt(65, 91); // Capital Letters 'A' to 'Z'.
        this.name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        this.course = courses[random.nextInt(3)];
        this.yearStarted = random.nextInt(2018, 2025);
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
}
