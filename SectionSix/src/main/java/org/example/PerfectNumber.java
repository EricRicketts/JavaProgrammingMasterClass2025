package org.example;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static boolean isPerfectNumber(int number) {
        int sumOfFactors = 0;
        if (number < 1) { return false; }

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) { sumOfFactors += i; }
        }

        return sumOfFactors == number;
    }
}
