package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private static String bankName;
    private final int accountNumber;
    private final BigDecimal balance;

    public BankAccount(String bankName, int accountNumber, BigDecimal balance) {
        BankAccount.bankName = bankName;
        this.accountNumber =
                ValueValidator.checkForNegativeValue(accountNumber, "Account number is less than zero");
        this.balance =
                ValueValidator.checkForNegativeValue(balance, "Balance is less than zero");
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
