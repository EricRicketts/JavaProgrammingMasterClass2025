package org.example;

import java.util.ArrayList;

public class FactorPrinter {

    public static String printFactors(int number) {
        if (number < 1) return "Invalid Value";
        StringBuilder factors = new StringBuilder();
        int firstFactor = 1, lastFactor = number;
        factors.append(firstFactor).append(" ");

        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                factors.append(i).append(" ");
            }
        }
        factors.append(lastFactor);
        return factors.toString().trim();
    }
}
