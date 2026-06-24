package org.example;

import java.math.BigDecimal;

public class ElectricCar extends Car {

    private BigDecimal avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, BigDecimal avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = AutoChecks.checkAvgKmPerCharge(avgKmPerCharge);
        this.batterySize = AutoChecks.checkBatterySize(batterySize);
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " " + "which is the future of all cars.";
    }

    @Override
    public String drive() {
        return super.drive() + " " + "which is quite a pleasant experience.";
    }

    @Override
    protected String runEngine() {
        return super.runEngine() + " " + "which has no engine but electric motors.";
    }

    public BigDecimal getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public void setAvgKmPerCharge(BigDecimal avgKmPerCharge) {
        this.avgKmPerCharge = AutoChecks.checkAvgKmPerCharge(avgKmPerCharge);
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = AutoChecks.checkBatterySize(batterySize);
    }
}
