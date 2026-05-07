package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class StudentInfo {

    private final String name;
    private final int id;
    private final BigDecimal gpa;

    public StudentInfo(String name, int id, BigDecimal gpa) {
        this.name = validateNameAndReturn(name);
        this.id = validateIDAndReturn(id);
        this.gpa = gpa;
    }

    private String validateNameAndReturn(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else {
            return name;
        }
    }

    private int validateIDAndReturn(int id) {
        if (id == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
            );
        }
        return id;
    }
}
