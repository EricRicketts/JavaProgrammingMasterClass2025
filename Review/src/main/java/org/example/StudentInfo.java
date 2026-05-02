package org.example;

import java.math.BigDecimal;

public class StudentInfo {

    private String name;
    private int id;
    private BigDecimal gpa;

    public StudentInfo(String name, int id, BigDecimal gpa) {
        this.name = ValueValidator.validateNameAndReturn(name);
    }

    private String validateNameAndReturn(String name) {
        ValueValidator.checkForNullValueOrBlankStringAndReturn(
                name,
                "Null value is not allowed for name",
                "Blank or empty value is not allowed for name"
        );
        return name;
    }
}
