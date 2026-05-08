package org.example;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class StudentInfo {

    private final String name;
    private final int id;
    private final BigDecimal gpa;

    public StudentInfo(String name, int id, BigDecimal gpa) {
        this.name = ValueValidator.validateNameAndReturn(name);
        this.id = ValueValidator.validateIDAndReturn(id);
        this.gpa = ValueValidator.validateGPAAndReturn(gpa);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public BigDecimal getGPA() {
        return gpa;
    }

    @Override
    @NotNull
    public String toString() {
        String scaledDimension = "%." + 2 + "f%n";
        return String.format(
                "Student Information:%n" +
                "name = %s%n" +
                "id = %d%n" +
                "gpa = " + scaledDimension,
                name,
                id,
                gpa
        ).trim();
    }
}