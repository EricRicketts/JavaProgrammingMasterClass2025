package org.example;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private Double accountBalance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Account() {
        this("56789", 2.50, "Default Name",
                "Default Email", "Default Phone");
    }

    public Account(String CustomerName, String CustomerEmail, String CustomerPhone) {
        this("99999", 100.55, CustomerName, CustomerEmail, CustomerPhone);
    }

    public Account(String accountNumber, Double accountBalance,
                   String customerName, String customerEmail,
                   String customerPhone) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public double roundToTwoDecimalPlaces (double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = roundToTwoDecimalPlaces(accountBalance);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void depositFunds(Double amount) {
        Double newBalance = amount + this.getAccountBalance();
        this.setAccountBalance(newBalance);
    }

    public String withdrawFunds(Double amount) {
        double newBalance;
        newBalance = this.getAccountBalance() - amount;
        if (newBalance < 0) {
            return "Insufficient Funds";
        } else {
            this.setAccountBalance(newBalance);
            return "Successfully Withdrawn";
        }
    }
}
