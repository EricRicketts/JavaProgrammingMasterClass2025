package org.example;

public class BankAccount {

    private static String bankName;
    private final int accountNumber;
    private final double balance;

    public BankAccount(String bankName, int accountNumber, double balance) {
        BankAccount.bankName = bankName;
        this.accountNumber =
            ValueValidator.checkForNegativeValue(accountNumber, "Account number is less than zero");
        this.balance = ValueValidator.checkForNegativeValue(balance, "Balance is less than zero");
    }

    public double getBalance() {
        return balance;
    }
}
