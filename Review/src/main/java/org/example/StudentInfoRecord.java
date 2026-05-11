package org.example;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public record StudentInfoRecord(String name, int id, BigDecimal gpa) {

    public StudentInfoRecord(String name, int id, BigDecimal gpa) {
        this.name = StudentInfo.validateNameAndReturn(name);
        this.id = StudentInfo.validateIDAndReturn(id);
        this.gpa = StudentInfo.validateGPAAndReturn(gpa);
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
