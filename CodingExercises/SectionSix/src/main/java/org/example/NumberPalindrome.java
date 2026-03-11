package org.example;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int originalNumber = number, reversedNumber = 0, currentDigit;
        while (number > 0) {
            currentDigit = number % 10;
            reversedNumber = reversedNumber * 10 + currentDigit;
            number = number / 10;
        }
        return reversedNumber == originalNumber;
    }
}
