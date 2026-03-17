package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParseString {

    public static String dateOfBirthInteger() {
        int currentYear = 2022;
        String usersDateOfBirth = "1999";
        int dateOfBirth = Integer.parseInt(usersDateOfBirth);
        return "Age = " + (currentYear - dateOfBirth);
    }

    public static String dateOfBirthDouble() {
        double firstInput = 45.56;
        BigDecimal firstInputBigDecimal =
                new BigDecimal(firstInput).setScale(2, RoundingMode.HALF_DOWN);
        String secondInput = "55.65";
        BigDecimal secondInputBigDecimal =
                new BigDecimal(secondInput).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal difference =
                (secondInputBigDecimal.subtract(firstInputBigDecimal));
        return "Result = " + difference;
    }
}
