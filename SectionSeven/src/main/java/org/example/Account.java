package org.example;

public class Account {

    private double balance;
    private String accountNumber, accountHolder, email, phoneNumber;

    public Account() {}

    public Account(String number, double balance, String customerName,
                   String email, String phone
    ) {
        this.accountNumber = number;
        this.balance = balance;
        this.accountHolder = customerName;
        this.email = email;
        this.phoneNumber = phone;
    }

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
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
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
