package org.example;

public class Account {

    private int accountNumber;
    private double balance;
    private String accountHolder, email, phoneNumber;

    public Account() {}
    public void deposit(double amount) {
        balance += amount;
    }

    public String withdraw(double amount) {
        if (balance < amount) {
            return "Insufficient Funds";
        } else {
            balance -= amount;
        }
        return "Withdrawal successful";
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
