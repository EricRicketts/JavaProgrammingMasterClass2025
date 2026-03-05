package org.example;

public class TeenNumberChecker {
    public static final int lowestTeen = 13;
    public static final int highestTeen = 19;

    public static boolean hasTeen(int first, int second, int third) {
        int[] ages = {first, second, third};
        for  (int i = 0; i <= ages.length; i++) { if (isTeen(ages[i])) { return true; } }
        return false;
    }

    public static boolean isTeen(int age) {
        return age >= lowestTeen && age <= highestTeen;
    }
}
