package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public record StudentInfoRecord(String name, int id, BigDecimal gpa) {

    public StudentInfoRecord(String name, int id, BigDecimal gpa) {
        this.name = ValueValidator.validateNameAndReturn(name);
        this.id = ValueValidator.validateIDAndReturn(id);
        this.gpa = ValueValidator.validateGPAAndReturn(gpa);
    }
}
