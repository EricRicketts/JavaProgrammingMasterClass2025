package org.example;

public class IntEqualityPrinter {

    public static String printEqual(int firstNumber, int secondNumber, int thirdNumber) {
        String message = "Invalid Value";
        if (firstNumber < 0 || secondNumber < 0 || thirdNumber < 0) return message;
        if (firstNumber == secondNumber && secondNumber == thirdNumber) {
            message = "All numbers are equal";
        } else if(firstNumber != secondNumber && secondNumber != thirdNumber && firstNumber != thirdNumber) {
            message = "All numbers are different";
        } else {
            message = "Neither all are equal or different";
        }
        return message;
    }
}
