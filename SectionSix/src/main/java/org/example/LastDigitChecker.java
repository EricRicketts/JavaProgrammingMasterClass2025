package org.example;

public class LastDigitChecker {

    public static boolean isValid(int number) {
        return number >= 10 &&  number <= 1000;
    }

    public static boolean hasSameLastDigit(int firstNumber, int secondNumber, int thirdNumber) {
        if (!isValid(firstNumber) || !isValid(secondNumber) || !isValid(thirdNumber)) { return false; }
        int firstNumberLastDigit = firstNumber % 10;
        int secondNumberLastDigit = secondNumber % 10;
        int thirdNumberLastDigit = thirdNumber % 10;

        return (firstNumberLastDigit == secondNumberLastDigit) ||
                (firstNumberLastDigit == thirdNumberLastDigit) ||
                (secondNumberLastDigit == thirdNumberLastDigit);
    }
}
