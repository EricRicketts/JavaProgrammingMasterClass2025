package org.example;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValueValidator {

    public static int checkForZeroValueAndReturn(int number, String message) {
        if (number == 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static BigDecimal checkForZeroValueAndReturn(BigDecimal number, String message) {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static int checkForNegativeValueAndReturn(int number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static BigDecimal checkForNegativeValueAndReturn(BigDecimal number, String message) {
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static <T> T checkForNullValueAndReturn(T value, String message) {
        return Objects.requireNonNull(value, message);
    }

    public static String checkForBlankValueAndReturn(String value, String message) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static String checkForEmptyValueAndReturn(String value, String message) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static String validateNameAndReturn(String name) {
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

    public static String validateAuthorAndReturn(String author) {
        if (Objects.isNull(author)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
        } else if (author.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
        } else if (author.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
        } else {
            return author;
        }
    }

    public static String validateCityAndReturn(String city) {
        if (Objects.isNull(city)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else if (city.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else if (city.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else {
            return city;
        }
    }

    public static String validateTitleAndReturn(String title) {
        if (Objects.isNull(title)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
        } else if (title.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
        } else if (title.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
        } else {
            return title;
        }
    }

    public static int validateIDAndReturn(int id) {
        if (id == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
            );
        } else if (id < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
            );
        } else {
            return id;
        }
    }

    public static int validateAgeAndReturn(int age) {
        if (age == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
            );
        } else if (age < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
            );
        } else {
            return age;
        }
    }

    public static int validatePagesAndReturn(int pages) {
        if (pages == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_PAGES.getErrorMessage()
            );
        } else if (pages < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_PAGES.getErrorMessage()
            );
        } else {
            return pages;
        }
    }

    public static BigDecimal validateGPAAndReturn(BigDecimal gpa) {
        if (Objects.isNull(gpa)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else {
            return gpa;
        }
    }

    public static BigDecimal validateDepositAndReturn( BigDecimal depositAmount ) {
        if (Objects.isNull(depositAmount)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage()
            );
        } else if (depositAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage()
            );
        } else {
            return depositAmount;
        }
    }

    public static BigDecimal validateWithdrawAndReturn(
            BigDecimal withdrawAmount
    ) {
        BigDecimal nonNullWithdrawAmount =
                ValueValidator.checkForNullValueAndReturn(
                        withdrawAmount,
                        ErrorMessages.NULL_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage()
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                NumberUtils.setScale(nonNullWithdrawAmount, 2),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage()
        );
    }


    public static BigDecimal ensureNonNegativeBalanceAfterWithdraw(BigDecimal newBalance, String message) {
        return ValueValidator.checkForNegativeValueAndReturn(newBalance, message);
    }

    public static String validateBankNameAndReturn(String bankName) {
        if (Objects.isNull(bankName)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
        } else if (bankName.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
        } else if (bankName.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
        } else {
            return bankName;
        }
    }

    public static int validateAccountNumberAndReturn(int accountNumber) {
        if (accountNumber == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
            );
        } else if (accountNumber < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
            );
        } else {
            return accountNumber;
        }
    }

    public static BigDecimal validateBalanceAndReturn(BigDecimal balance) {
        if (balance == null) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
            );
        } else if (balance.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
            );
        } else if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
            );
        } else {
            return balance;
        }
    }

    public static BigDecimal validateAndScaleWidth(BigDecimal width, int scaleFactor) {
        if (Objects.isNull(width)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else if (width.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else if (width.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else {
            return NumberUtils.setScale(width, scaleFactor);
        }
    }

    public static BigDecimal validateAndScaleHeight(BigDecimal height, int scaleFactor) {
        if (Objects.isNull(height)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else if (height.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else if (height.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else {
            return NumberUtils.setScale(height, scaleFactor);
        }
    }

    public static int validateScaleFactor(int scaleFactor) {
        int nonZeroScaleFactor =
                ValueValidator.checkForZeroValueAndReturn(
                        scaleFactor,
                        ErrorMessages.ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                nonZeroScaleFactor,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );
    }
}