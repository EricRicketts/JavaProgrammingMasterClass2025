package org.example;

import java.math.BigDecimal;

public class Account {

    private Integer accountNumber;
    private Double accountBalance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public double roundToTwoDecimalPlaces (double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
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

}
