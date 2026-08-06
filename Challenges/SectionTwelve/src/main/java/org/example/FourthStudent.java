package org.example;

import javax.management.Query;
import java.util.Random;

public class FourthStudent implements QueryItem  {

    private String name;
    private String course;
    private int yearStarted;
    private static Random random = new Random();
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public FourthStudent() {
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

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String localFieldName = fieldName.toUpperCase();
        return switch (localFieldName) {
            case "NAME" -> this.getName().split("\\s+")[0].equalsIgnoreCase(value);
            case "COURSE" -> this.getCourse().equalsIgnoreCase(value);
            case "YEARSTARTED" -> this.getYearStarted() == Integer.parseInt(value);
            default -> false;
        };
    }
}
