package org.example;

public class PrimeNumberChallenge {

    public static boolean isPrime(int number) {
        if (number <= 2) { return number == 2; }
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) { return false; }
        }
        return true;
    }
}
