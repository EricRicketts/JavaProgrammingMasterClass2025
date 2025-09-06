package org.example;

public class CodingExerciseSixDecimalComparatorThreePlaces {

    public boolean areEqualByThreeDecimalPlaces(double first, double second) {
        double thousand = 1000;
        int firstInt = (int) (first * thousand);
        int secondInt = (int) (second * thousand);
        return firstInt ==  secondInt;
    }
}
