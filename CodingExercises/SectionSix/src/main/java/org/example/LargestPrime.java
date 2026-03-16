package org.example;

public class LargestPrime {

    public static int getLargestPrime(int number) {
        int largestPrime = 2;
        if (number <= 1) return -1;
        for (int factor = 2; factor <= number / 2; factor++) {
            if (number % factor == 0) {
                if (PrimeNumberChecker.isPrime(factor)) {
                    largestPrime = factor;
                }
            }
        }
        return largestPrime;
    }
}
