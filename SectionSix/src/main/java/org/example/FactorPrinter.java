package org.example;

import java.util.ArrayList;
import java.util.List;

public class FactorPrinter {

    public static List<Integer> printFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number < 1) {
            factors.add(-1);
            return factors;
        }

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        factors.add(number);

        return factors;
    }
}
