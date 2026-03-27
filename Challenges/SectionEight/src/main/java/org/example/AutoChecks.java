package org.example;

public class AutoChecks {

    public static double checkAvgKmPerCharge(double avgKmPerCharge) {
        return (avgKmPerCharge < 0) ? 300.00 : avgKmPerCharge;
    }

    public static double checkAvgKmPerLitre(double avgKmPerLitre) {
        return (avgKmPerLitre < 0) ? 15.00 : avgKmPerLitre;
    }

    public static int checkBatterySize(int batterySize) {
        return (batterySize < 0) ? 50 : batterySize;
    }

    public static int checkCylinders(int cylinders) {
        return (cylinders < 0) ? 4 : cylinders;
    }
}
