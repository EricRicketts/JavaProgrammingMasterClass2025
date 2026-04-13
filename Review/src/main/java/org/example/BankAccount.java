package org.example;

public class BankAccount {

    private static String bankName;
    private final int accountNumber;
    private final double balance;

    public BankAccount(String bankName, int accountNumber, double balance) {
        BankAccount.bankName = bankName;
        this.accountNumber =
            ValueValidator.checkForNegativeInteger(accountNumber, "Account number is less than zero");
        this.balance = ValueValidator.setScale(balance, 2);
    }

    public double getBalance() {
        return balance;
    }
}
