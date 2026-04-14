package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private String bankName;
    private final int accountNumber;
    private BigDecimal balance;

    public BankAccount(String bankName, int accountNumber, BigDecimal balance) {
        this.bankName =
                ValueValidator.checkForNull(bankName,
                "Null value not allowed for bank name");
        this.accountNumber =
                ValueValidator.checkForNegativeValue(accountNumber,
                        "Account number is less than zero");
        BigDecimal nonNegativeBalance =
                ValueValidator.checkForNegativeValue(balance,
                        "Balance is less than zero");
        this.balance = NumberUtils.setScale(nonNegativeBalance, 2);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal depositAmount) {
        ValueValidator.checkForNegativeValue(
                depositAmount,
                "Deposit amount cannot be less than zero"
        );
        this.balance = NumberUtils.setScale(this.balance.add(depositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        ValueValidator.checkForNegativeValue(
                withdrawAmount,
                "Withdraw amount cannot be less than zero"
        );
        BigDecimal currentBalance = this.balance;
        currentBalance = ValueValidator.checkForNegativeValue(
                currentBalance.subtract(withdrawAmount),
                "Insufficient Funds"
        );
        this.balance = NumberUtils.setScale(currentBalance, 2);
    }
}
