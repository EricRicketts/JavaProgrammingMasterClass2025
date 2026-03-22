package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee() {
        super();
        this.annualSalary = 0.0;
        this.isRetired = false;
    }

    public SalariedEmployee(
            String name, String birthDate, String endDate,
            long employeeId, String hireDate, double annualSalary,
            boolean isRetired) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void retire() {
        this.isRetired = true;
    }

    public void setRetired(boolean retired) {
        this.isRetired = retired;
    }

    public boolean isRetired() {
        return this.isRetired;
    }

    @Override
    public double collectPay() {
        BigDecimal monthlyPay = new BigDecimal(this.getAnnualSalary() / 12);
        monthlyPay = monthlyPay.setScale(2, RoundingMode.HALF_UP);
        return monthlyPay.doubleValue();
    }
}
