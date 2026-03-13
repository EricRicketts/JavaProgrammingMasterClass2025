package org.example;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) return false;
        int sumOfFactors = 1; // Initialize at 1 because 1 is a factor of any number
        // and we start the factor loop at 2.
        for (int factor = 2; factor <= number / 2; factor++) {
            if (number % factor == 0) {
                sumOfFactors += factor;
            }
        }
        return sumOfFactors == number;
    }
}
