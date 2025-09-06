package org.example;

public class CodingExerciseTwoSpeedConverter {

    public long toMilesPerHour(double kilometersPerHour) {
        double kilometersPerMile = 1.609;
        long milesPerHour = -1;

        if (kilometersPerHour >= 0) {
            milesPerHour = Math.round(kilometersPerHour / kilometersPerMile);
        }

        return  milesPerHour;
    }

    public String printConversion(double kilometersPerHour) {
        String result = "Invalid Value";
        long milesPerHour;

        if (kilometersPerHour >= 0) {
            milesPerHour = toMilesPerHour(kilometersPerHour);
            result = STR."\{kilometersPerHour} km/h = \{milesPerHour} mi/h";
        }

        return result;
    }
}
