package org.example;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {
        int firstNumberInteger = (int) (firstNumber * 1000);
        int secondNumberInteger = (int) (secondNumber * 1000);
        return (firstNumberInteger == secondNumberInteger);
    }
}
