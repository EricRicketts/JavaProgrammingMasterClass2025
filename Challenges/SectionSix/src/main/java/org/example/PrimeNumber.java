package org.example;

import java.util.ArrayList;

public class PrimeNumber {
    public static boolean isPrimeNumber(int number) {
        if (number <= 2) {
            return (number == 2);
        } else {
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Integer[] selectThreePrimeNumbers(int startingNumber) {
        ArrayList<Integer> generatedPrimeNumbers = new ArrayList<>();
        for (int number = startingNumber; number <= 1000; number++) {
            if (isPrimeNumber(number)) {
                generatedPrimeNumbers.add(number);
                if (generatedPrimeNumbers.size() == 3) {
                    break;
                }
            }
        }
        return generatedPrimeNumbers.toArray(new Integer[0]);
    }
}
