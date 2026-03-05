package org.example;

public class ConversionChallenge {

    public static double inchesToCentimeters = 2.54;
    public static int feetToInches = 12;

    public static double convertToCentimeters(int inches) {
        return inches * inchesToCentimeters;
    }

    public static double convertToCentimeters(int feet, int inches) {
        int totalInches =  feet * feetToInches + inches;
        return convertToCentimeters(totalInches);
    }
}
