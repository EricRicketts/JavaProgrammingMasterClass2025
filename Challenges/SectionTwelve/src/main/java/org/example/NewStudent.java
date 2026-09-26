package org.example;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class NewStudent implements Comparable<NewStudent>, QueryItemChallenge {

    private static final Comparator<NewStudent> STUDENT_COMPARATOR =
        Comparator.comparingInt(NewStudent::getId)
            .thenComparing(NewStudent::getName)
            .thenComparing(NewStudent::getCourse)
            .thenComparing(NewStudent::getYearStarted);

    private String name;
    private String course;
    private int id;
    private int yearStarted;

    public NewStudent(String name, String course, int id, int yearStarted) {
        this.name = name;
        this.course = course;
        this.id = id;
        this.yearStarted = yearStarted;
    }

    public NewStudent() {
        this.name = "Unknown";
        this.course = "None";
        this.id = 0;
        this.yearStarted = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    @Override
    public String toString() {
        return "Student name is " + name + ".  Student id is " + id + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        NewStudent student = (NewStudent) object;
        return getId() == student.getId() &&
            getYearStarted() == student.getYearStarted() &&
            java.util.Objects.equals(getName(), student.getName()) &&
            java.util.Objects.equals(getCourse(), student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCourse(), getId(), getYearStarted());
    }


    @Override
    public int compareTo(@NotNull NewStudent other) {
        return STUDENT_COMPARATOR.compare(this, other);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String localFieldName = fieldName.toUpperCase();
        return switch (localFieldName) {
            case "NAME" -> {
                String[] currentNames = this.getName().split("\\s+");
                String[] incomingNames = value.split("\\s+");
                int currentNameLength = currentNames.length;
                int incomingNameLength = incomingNames.length;
                if (currentNameLength != incomingNameLength) yield false;
                boolean namesTheSame = true;
                for (int index = 0; index < currentNameLength; index+=1) {
                    if (!currentNames[index].equalsIgnoreCase(incomingNames[index])) {
                        namesTheSame = false;
                        break;
                    }
                }
                yield namesTheSame;
            }
            case "COURSE" -> this.getCourse().equalsIgnoreCase(value);
            case "ID" -> this.getId() == Integer.parseInt(value);
            case "YEARSTARTED" -> this.getYearStarted() == Integer.parseInt(value);
            default -> false;
        };
    }
}
