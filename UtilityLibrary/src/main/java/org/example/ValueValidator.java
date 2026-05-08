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
        String literalValue = "name";
        if (Objects.isNull(name)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(literalValue)
            );
        } else if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(literalValue)
            );
        } else {
            return name;
        }
    }

    public static String validateAuthorAndReturn(String author) {
        String literalValue = "author";
        if (Objects.isNull(author)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (author.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(literalValue)
            );
        } else if (author.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(literalValue)
            );
        } else {
            return author;
        }
    }

    public static String validateCityAndReturn(String city) {
        String literalValue = "city";
        if (Objects.isNull(city)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (city.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(literalValue)
            );
        } else if (city.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(literalValue)
            );
        } else {
            return city;
        }
    }

    public static String validateTitleAndReturn(String title) {
        String literalValue = "title";
        if (Objects.isNull(title)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (title.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(literalValue)
            );
        } else if (title.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(literalValue)
            );
        } else {
            return title;
        }
    }

    public static int validateIDAndReturn(int id) {
        String literalValue = "id";
        if (id == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (id < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return id;
        }
    }

    public static int validateAgeAndReturn(int age) {
        String literalValue = "age";
        if (age == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (age < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return age;
        }
    }

    public static int validatePagesAndReturn(int pages) {
        String literalValue = "pages";
        if (pages == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (pages < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return pages;
        }
    }

    public static BigDecimal validateGPAAndReturn(BigDecimal gpa) {
        String literalValue = "gpa";
        if (Objects.isNull(gpa)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return gpa;
        }
    }

    public static BigDecimal validateDepositAndReturn(BigDecimal depositAmount) {
        String literalValue = "deposit";
        if (Objects.isNull(depositAmount)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (depositAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return depositAmount;
        }
    }

    public static BigDecimal validateWithdrawAndReturn(BigDecimal withdrawAmount) {
        String literalValue = "withdraw";
        BigDecimal nonNullWithdrawAmount =
                ValueValidator.checkForNullValueAndReturn(
                        withdrawAmount,
                        ErrorMessages.nullValue(literalValue)
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                NumberUtils.setScale(nonNullWithdrawAmount, 2),
                ErrorMessages.negativeValue(literalValue)
        );
    }


    public static BigDecimal ensureNonNegativeBalanceAfterWithdraw(BigDecimal newBalance, String message) {
        return ValueValidator.checkForNegativeValueAndReturn(newBalance, message);
    }

    public static String validateBankNameAndReturn(String bankName) {
        String literalValue = "bank name";
        if (Objects.isNull(bankName)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (bankName.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(literalValue)
            );
        } else if (bankName.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(literalValue)
            );
        } else {
            return bankName;
        }
    }

    public static int validateAccountNumberAndReturn(int accountNumber) {
        String literalValue = "account number";
        if (accountNumber == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (accountNumber < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return accountNumber;
        }
    }

    public static BigDecimal validateBalanceAndReturn(BigDecimal balance) {
        String literalValue = "balance";
        if (balance == null) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (balance.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return balance;
        }
    }

    public static BigDecimal validateAndScaleWidth(BigDecimal width, int scaleFactor) {
        String literalValue = "width";
        if (Objects.isNull(width)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (width.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (width.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return NumberUtils.setScale(width, scaleFactor);
        }
    }

    public static BigDecimal validateAndScaleHeight(BigDecimal height, int scaleFactor) {
        String literalValue = "height";
        if (Objects.isNull(height)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (height.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (height.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return NumberUtils.setScale(height, scaleFactor);
        }
    }

    public static BigDecimal validateAndScaleSide(BigDecimal side, int scaleFactor) {
        String literalValue = "side";
        if (Objects.isNull(side)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(literalValue)
            );
        } else if (side.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(literalValue)
            );
        } else if (side.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(literalValue)
            );
        } else {
            return NumberUtils.setScale(side, scaleFactor);
        }
    }
    public static int validateScaleFactor(int scaleFactor) {
        String literalValue = "scale factor";
        int nonZeroScaleFactor =
                ValueValidator.checkForZeroValueAndReturn(
                        scaleFactor,
                        ErrorMessages.zeroValue(literalValue)
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                nonZeroScaleFactor,
                ErrorMessages.negativeValue(literalValue)
        );
    }
}