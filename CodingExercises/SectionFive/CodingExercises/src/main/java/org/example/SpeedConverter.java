package org.example;

public class SpeedConverter {

    private static double kiloMetersPerMile = 1/1.609;
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) return -1;
        double milesPerHour = kilometersPerHour * kiloMetersPerMile;
        return Math.round(milesPerHour);
    }

    public static String printConversion(double kiloMetersPerHour) {
        long milesPerHour = toMilesPerHour(kiloMetersPerHour);
        String message = "Invalid Value";
        if (milesPerHour >= 0) {
            message = kiloMetersPerHour + " km/h" + " = " + milesPerHour + " mi/h";
        }
        return message;
    }
}
