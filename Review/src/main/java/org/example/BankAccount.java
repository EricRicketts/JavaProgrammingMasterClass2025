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
                NumberUtils.setScale(balance, 2)
        ).trim();
    }

    public void deposit(BigDecimal depositAmount) {
        BigDecimal validDepositAmount = validateDepositAndReturn(
                depositAmount
        );
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal validWithdrawAmount = validateWithdrawAndReturn(
                withdrawAmount
        );

        this.balance = ensureNonNegativeBalanceAfterWithdraw(
                NumberUtils.setScale(this.balance.subtract(validWithdrawAmount), 2),
                ErrorMessages.INSUFFICIENT_FUNDS_MESSAGE_FOR_WITHDRAW.getErrorMessage()
        );
    }

    private BigDecimal validateDepositAndReturn(
            BigDecimal depositAmount
    ) {
        BigDecimal nonNullDepositAmount =
                ValueValidator.checkForNullValueAndReturn(
                        depositAmount,
                        ErrorMessages.NULL_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage()
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                NumberUtils.setScale(nonNullDepositAmount, 2),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage()
        );
    }

    private BigDecimal validateWithdrawAndReturn(
            BigDecimal withdrawAmount
    ) {
        BigDecimal nonNullWithdrawAmount =
                ValueValidator.checkForNullValueAndReturn(
                        withdrawAmount,
                        ErrorMessages.NULL_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage()
                );

        return ValueValidator.checkForNegativeValueAndReturn(
                NumberUtils.setScale(nonNullWithdrawAmount, 2),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage()
        );
    }


    private BigDecimal ensureNonNegativeBalanceAfterWithdraw(BigDecimal newBalance, String message) {
        return ValueValidator.checkForNegativeValueAndReturn(newBalance, message);
    }

   private String validateBankNameAndReturn(String bankName) {
        String nonNullBankName = ValueValidator.checkForNullValueAndReturn(
            bankName,
            ErrorMessages.NULL_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
        );

        String nonEmptyBankName = ValueValidator.checkForEmptyValueAndReturn(
                nonNullBankName,
                ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
        );

        return ValueValidator.checkForBlankValueAndReturn(
           nonEmptyBankName,
           ErrorMessages.BLANK_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
       );
   }

   private int validateAccountNumberAndReturn(int accountNumber) {
        int nonZeroAccountNumber = ValueValidator.checkForZeroValueAndReturn(
                accountNumber,
                ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
        );

        return ValueValidator.checkForNegativeValueAndReturn(
                nonZeroAccountNumber,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
        );
   }

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
}
