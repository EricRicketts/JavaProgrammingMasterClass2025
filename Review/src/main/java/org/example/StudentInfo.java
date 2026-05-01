package org.example;

import java.math.BigDecimal;

public class StudentInfo {

    private String name;
    private int id;
    private BigDecimal gpa;

    public StudentInfo(String name, int id, BigDecimal gpa) {
        this.name = ValueValidator.validateNameAndReturn(name);
    }
}
