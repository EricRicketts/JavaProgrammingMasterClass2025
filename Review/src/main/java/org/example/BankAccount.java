package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private final String bankName;
    private final int accountNumber;
    private BigDecimal balance;

    public BankAccount(String bankName, int accountNumber, BigDecimal balance) {
        this.bankName = validateBankNameAndReturn(bankName);
        this.accountNumber = validateAccountNumberAndReturn(accountNumber);
        BigDecimal nonNullOrNonNegativeBalance = validateBalanceAndReturn(balance);
        this.balance = NumberUtils.setScale(nonNullOrNonNegativeBalance, 2);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format(
                "Bank name = %s%n" +
                "Account number = %s%n" +
                "Current balance = %s%n",
                bankName,
                accountNumber,
                balance
        ).trim();
    }

    public void deposit(BigDecimal depositAmount) {
        BigDecimal validDepositAmount = validateDepositAndReturn(depositAmount);
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal nonNegativeWithdraw = validateWithdrawAndReturn(withdrawAmount);

        if (nonNegativeWithdraw.compareTo(this.balance) > 0) {
            throw new IllegalArgumentException("Insufficient funds for withdraw");
        } else {
            this.balance = NumberUtils.setScale(this.balance.subtract(nonNegativeWithdraw), 2);
        }
    }

    private String validateBankNameAndReturn(String bankName) {
        return ValueValidator.validateTextAndReturn(bankName, "bank name");
    }

    private int validateAccountNumberAndReturn(int accountNumber) {
        return ValueValidator.validatePositiveIntAndReturn(accountNumber, "account number");
    }

    private BigDecimal validateBalanceAndReturn(BigDecimal balance) {
        return ValueValidator.validateNonNegativeBigDecimalAndReturn(balance, "balance");
    }

    private BigDecimal validateDepositAndReturn(BigDecimal deposit) {
        return ValueValidator.validateNonNegativeBigDecimalAndReturn(deposit, "deposit");
    }

    private BigDecimal validateWithdrawAndReturn(BigDecimal withdraw) {
        return ValueValidator.validateNonNegativeBigDecimalAndReturn(withdraw, "withdraw");
    }
}
