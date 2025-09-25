package org.example;

public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        /*
            use 252 as an example; sum should be 4
            252 % 10 = 2 this is the last number
            252 / 10 = 25 get the remaining number

            25 % 10 = 5 this is the middle number
            25 / 10 = 2 this is the remaining number

            the remaining number is < 10 so we know it is the first number
            so now sum first and last number

            so we run the loop until the remaining number is less than 10
        */
        if (number < 0) return -1;
        int firstDigit = 0, lastDigit = number % 10;
        while (number >= 10) {
            number  = number / 10;
        }
        firstDigit = number ;
        return firstDigit + lastDigit;
    }
}
