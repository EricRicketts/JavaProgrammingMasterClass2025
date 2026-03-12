package org.example;

public class SharedDigit {

    /*
        If I restrict myself to what I have learned so far, then I cannot use Arrays
        and any method for is a number a member of an array.
    */
    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        int originalSecondNumber = secondNumber;
        boolean foundSharedDigit = false;
        boolean firstNumberCheck = firstNumber >= 10 && firstNumber <= 99;
        boolean secondNumberCheck = secondNumber >= 10 && secondNumber <= 99;
        if (!firstNumberCheck || !secondNumberCheck) return false;

        outerLoop:
        while (firstNumber > 0) {
            int currentDigitOfFirstNumber = firstNumber % 10;
            while (secondNumber > 0) {
               int currentDigitOfSecondNumber = secondNumber % 10;
               if (currentDigitOfFirstNumber == currentDigitOfSecondNumber) {
                   foundSharedDigit = true;
                   break outerLoop;
               } else {
                   secondNumber = secondNumber / 10;
               }
            }
            firstNumber = firstNumber / 10;
            secondNumber = originalSecondNumber;
        }
        return foundSharedDigit;
    }
}
