package org.example;

public class PrimeNumberChallenge {

    public static boolean isPrime(int number) {
        if (number <= 2) { return number == 2; }
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            // take an example of 7, by integer division 7 / 2 = 3
            // 7 % 2 = 1
            // 7 % 3 = 1, so return true
            // number / 2 would be its largest factor other than the number itself
            // so if number / 2 is not a divisor then there is not need to check
            // for numbers > number / 2 and less than the number itself
            if (number % divisor == 0) { return false; }
        }
        return true;
    }
}
