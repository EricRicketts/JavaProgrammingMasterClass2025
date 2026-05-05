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
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage() );
        return ValueValidator.checkForBlankValueAndReturn(
                nonNullName,
                ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage() );
    }

    private int validateIDAndReturn(int id) {
        int nonZeroId = ValueValidator.checkForZeroValueAndReturn(
                id,
                ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
        return  ValueValidator.checkForNegativeValueAndReturn(
                nonZeroId,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
    }

    private BigDecimal validateGPAAndReturn(BigDecimal gpa) {
        BigDecimal nonZeroGpa = ValueValidator.checkForZeroValueAndReturn(
                gpa,
                ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
        return  ValueValidator.checkForNegativeValueAndReturn(
                nonZeroGpa,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
        );
    }
}


