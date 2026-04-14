package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private final String bankName;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal depositAmount) {
        BigDecimal validDepositAmount = ensureValidAmount(
                depositAmount,
                "Null value not allowed for deposit amount",
                "Deposit amount cannot be less than zero"
        );
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal validWithdrawAmount = ensureValidAmount(
                withdrawAmount,
                "Null value not allowed for withdraw amount",
                "Withdraw amount cannot be less than zero"
        );

        BigDecimal remainingBalance = ensureNonNegativeBalanceAfterWithdraw(
                this.balance.subtract(validWithdrawAmount)
        );
        this.balance = NumberUtils.setScale(remainingBalance, 2);
    }

    private BigDecimal ensureValidAmount(
            BigDecimal amount,
            String nullMessage,
            String negativeMessage
    ) {
        ValueValidator.checkForNull(amount, nullMessage);
        ValueValidator.checkForNegativeValue(amount, negativeMessage);
        return amount;
    }

    private BigDecimal ensureNonNegativeBalanceAfterWithdraw(BigDecimal newBalance) {
        return ValueValidator.checkForNegativeValue(newBalance, "Insufficient funds");
    }
}
