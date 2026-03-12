package org.example;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {
        boolean check = (first >= 10 && second >= 10);
        if (!check) return -1;
        int greatestCommonDivisor = getLargestCommonDivisor(first, second);
        return greatestCommonDivisor;
    }

    private static int getLargestCommonDivisor(int first, int second) {
        int lesser = 1, greater = 1, greatestCommonDivisor = 1;
        if (first <= second) { lesser = first; greater = second; }
        if (second < first) { lesser = second; greater = first; }

        for (int factor = 1; factor <= lesser/2; factor++) {
            boolean commonDenominatorCheck = (lesser % factor == 0) && (greater % factor == 0);
            if (commonDenominatorCheck) { greatestCommonDivisor = factor; }
        }
        if (greater % lesser == 0) { greatestCommonDivisor = lesser; }
        return greatestCommonDivisor;
    }
}
