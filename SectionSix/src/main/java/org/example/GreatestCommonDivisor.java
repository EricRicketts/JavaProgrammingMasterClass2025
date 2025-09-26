package org.example;

import java.util.ArrayList;
import java.util.List;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) return -1;
        int greatestCommonDivisor = 0;
        List<Integer> firstNumberFactors = new ArrayList<>();
        List<Integer> secondNumberFactors = new ArrayList<>();
        for (int i = 1; i <= first / 2; i++) {
            if (first % i == 0) {
                firstNumberFactors.add(i);
            }
        }
        firstNumberFactors.add(first);
        for (int i = 1; i <= second / 2; i++) {
            if (second % i == 0) {
                secondNumberFactors.add(i);
            }
        }
        secondNumberFactors.add(second);

        for (int firstNumberFactor : firstNumberFactors) {
            for (int secondNumberFactor : secondNumberFactors) {
                if (firstNumberFactor == secondNumberFactor) {
                    greatestCommonDivisor = firstNumberFactor;
                    break;
                }
            }
        }
        return greatestCommonDivisor;
    }
}
