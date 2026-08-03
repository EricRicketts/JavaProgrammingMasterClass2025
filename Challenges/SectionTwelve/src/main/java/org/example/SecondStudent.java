package org.example;

import java.math.BigDecimal;

public class SecondStudent implements Comparable<SecondStudent> {

    private String name;
    private int id;
    private BigDecimal gpa;

    public SecondStudent(String name, int id, BigDecimal gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student name is " + name +
            ".  Student id is " + id + ".  Student gpa is " + gpa + ".";
    }

    @Override
    public int compareTo(SecondStudent other) {
        int gpaComparisonResult = this.getGpa().compareTo(other.getGpa());
        if (gpaComparisonResult != 0) {
            return gpaComparisonResult;
        }
        int nameComparisonResult = this.getName().compareTo(other.getName());
        if (nameComparisonResult != 0) {
            return nameComparisonResult;
        }
        return Integer.compare(this.getId(), other.getId());
    }
}
