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
        this.bankName = ValueValidator.checkForNull(bankName, "Null value not allowed for bank name");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal depositAmount) {
        ValueValidator.checkForNull(depositAmount, "Null value not allowed for deposit amount");
        ValueValidator.checkForNegativeValue(
                depositAmount,
                "Deposit amount cannot be less than zero"
        );
        this.balance = NumberUtils.setScale(this.balance.add(depositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        ValueValidator.checkForNull(withdrawAmount, "Null value not allowed for withdraw amount");
        ValueValidator.checkForNegativeValue(
                withdrawAmount,
                "Withdraw amount cannot be less than zero"
        );
        this.balance = ValueValidator.checkForNegativeValue(
                this.balance.subtract(withdrawAmount),
                "Insufficient Funds"
        );
        this.balance = NumberUtils.setScale(this.balance, 2);
    }
}
