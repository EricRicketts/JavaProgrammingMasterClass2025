package org.example;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class BankAccount {

    private final String bankName;
    private final int accountNumber;
    private BigDecimal balance;

    public BankAccount(String bankName, int accountNumber, BigDecimal balance) {
        this.bankName = ValueValidator.validateBankNameAndReturn(bankName);
        this.accountNumber = ValueValidator.validateAccountNumberAndReturn(accountNumber);
        BigDecimal nonNullOrNonNegativeBalance = ValueValidator.validateBalanceAndReturn(balance);
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
                NumberUtils.setScale(balance, 2)
        ).trim();
    }

    public void deposit(BigDecimal depositAmount) {
        BigDecimal validDepositAmount = ValueValidator.validateDepositAndReturn(depositAmount);
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal validWithdrawAmount = ValueValidator.validateWithdrawAndReturn(withdrawAmount);

        this.balance = ValueValidator.ensureNonNegativeBalanceAfterWithdraw(
                NumberUtils.setScale(this.balance.subtract(validWithdrawAmount), 2),
                ErrorMessages.INSUFFICIENT_FUNDS_MESSAGE_FOR_WITHDRAW.getErrorMessage()
        );
    }

    /*
   private BigDecimal validateBalanceAndReturn(BigDecimal balance) {
        BigDecimal nonNullBalance = ValueValidator.checkForNullValueAndReturn(
                balance,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
        );

        return ValueValidator.checkForNegativeValueAndReturn(
                NumberUtils.setScale(nonNullBalance, 2),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
        );
   }

     */
}
