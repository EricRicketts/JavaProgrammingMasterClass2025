package org.example;

public class InterestRate {
    public static double calculateInterest(double amount, double rate) {
        double interestRate = rate / 100;
        return amount * interestRate;
    }
}
