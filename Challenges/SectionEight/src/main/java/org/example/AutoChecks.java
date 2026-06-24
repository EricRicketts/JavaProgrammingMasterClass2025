package org.example;

import java.math.BigDecimal;

public class AutoChecks {

    public static BigDecimal checkAvgKmPerCharge(BigDecimal avgKmPerCharge) {
        return (avgKmPerCharge.compareTo(BigDecimal.ZERO) < 0) ? new BigDecimal("300.00") : avgKmPerCharge;
    }

    public static BigDecimal checkAvgKmPerLitre(BigDecimal avgKmPerLitre) {
        return (avgKmPerLitre.compareTo(BigDecimal.ZERO) < 0) ? new BigDecimal("15.00") : avgKmPerLitre;
    }

    public static BigDecimal checkAvgKmPerLitreForHybrid(BigDecimal avgKmPerLitre) {
        return (avgKmPerLitre.compareTo(BigDecimal.ZERO) < 0) ? new BigDecimal("20.00") : avgKmPerLitre;
    }

    public static int checkBatterySize(int batterySize) {
        return (batterySize < 0) ? 50 : batterySize;
    }

    public static int checkCylinders(int cylinders) {
        return (cylinders < 0) ? 4 : cylinders;
    }
}
