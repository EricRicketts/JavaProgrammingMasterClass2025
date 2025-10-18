package org.example;

public class AgeCalculator {

    public static int getAgeInteger (String year, String yearOfBirth) {
        int currentYear = 0, birthYear = 0;

        currentYear = Integer.parseInt(year);
        birthYear = Integer.parseInt(yearOfBirth);


        return currentYear - birthYear;
    }

    public static double getAgeDouble (String year, String yearOfBirth) {
        double currentYear = 0, birthYear = 0;

        currentYear = Double.parseDouble(year);
        birthYear = Double.parseDouble(yearOfBirth);

        return  currentYear - birthYear;
    }
}
