package org.example;

import java.util.Arrays;
import java.util.List;

public class IntEqualityPrinter {

    public static String printEqual(int first, int second, int third) {
        int[] parameters = {first, second, third};
        boolean isAnyParameterZero = parameters[0] == 0 || parameters[1] == 0 || parameters[2] == 0;
        boolean areAllParametersEqual =
                (parameters[0] == parameters[1]) && (parameters[1] == parameters[2]);
        boolean areAllParametersDifferent =
                (parameters[0] != parameters[1]) && (parameters[0] != parameters[2])
                        && (parameters[1] != parameters[2]);

        if (isAnyParameterZero) {
            return "Invalid Value";
        } else if (areAllParametersEqual) {
            return "All numbers are equal";
        } else if (areAllParametersDifferent) {
            return "All numbers are different";
        } else {
            return "Neither all are equal or different";
        }
    }
}
