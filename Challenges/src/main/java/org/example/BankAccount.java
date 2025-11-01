package org.example;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String withdrawError = "No Error account not overdrawn";

    public BankAccount() {
        this(0,0.00,"Default name",
                "Default email","Default phone");
    }

    public BankAccount(int accountNumber, double balance,
                       String customerName, String customerEmail,
                       String customerPhone) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
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

    public String getWithdrawError() {
        return withdrawError;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void depositFunds (double deposit) {
        this.balance += deposit;
    }

    public void withdrawFunds (double withdraw) {
        if (this.balance - withdraw < 0) {
            this.withdrawError = "Withdraw denied balance less than zero";
        } else {
            this.balance -= withdraw;
        }
    }
}
