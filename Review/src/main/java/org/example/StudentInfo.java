package org.example;

import java.math.BigDecimal;

public class StudentInfo {

    private String name;
    private int id;
    private BigDecimal gpa;

    public StudentInfo(String name, int id, BigDecimal gpa) {
        this.name = validateNameAndReturn(name);
        this.id = validateIDAndReturn(id);
        this.gpa = validateGPAAndReturn(gpa);
    }

    private String validateNameAndReturn(String name) {
        String nonNullName = ValueValidator.checkForNullValueAndReturn(
                name,
                ErrorMessage.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
        );
        return ValueValidator.checkForBlankValueAndReturn(
                nonNullName,
                ErrorMessage.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
        );
    }

    private int validateIDAndReturn(int id) {
        int nonZeroId = ValueValidator.checkForZeroValueAndReturn(
                id,
                ErrorMessage.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
        return  ValueValidator.checkForNegativeValueAndReturn(
                nonZeroId,
                ErrorMessage.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
    }

    private BigDecimal validateGPAAndReturn(BigDecimal gpa) {
        BigDecimal nonZeroGpa = ValueValidator.checkForZeroValueAndReturn(
                gpa,
                ErrorMessage.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
        return  ValueValidator.checkForNegativeValueAndReturn(
                nonZeroGpa,
                ErrorMessage.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
    }
}


