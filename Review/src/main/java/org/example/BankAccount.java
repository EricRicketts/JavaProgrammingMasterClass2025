package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private final String bankName;
    private final int accountNumber;
    private BigDecimal balance;

    public BankAccount(String bankName, int accountNumber, BigDecimal balance) {
        this.bankName = validateBankNameAndReturn(bankName);
        this.accountNumber = validateAccountNumberAndReturn(accountNumber);
        BigDecimal nonNullOrNonNegativeBalance =
                this.validateDepositAndReturn(balance,
                        "Null value not allowed for balance",
                        "Balance is less than zero");
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

    public void deposit(BigDecimal depositAmount) {
        BigDecimal validDepositAmount = validateDepositAndReturn(
                depositAmount,
                "Null value not allowed for deposit amount",
                "Deposit amount cannot be less than zero"
        );
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal validWithdrawAmount = validateWithdrawAndReturn(
                withdrawAmount,
                "Null value not allowed for withdraw amount",
                "Withdraw amount cannot be less than zero"
        );

        BigDecimal remainingBalance = ensureNonNegativeBalanceAfterWithdraw(
                this.balance.subtract(validWithdrawAmount),
                "Insufficient funds"
        );
        this.balance = NumberUtils.setScale(remainingBalance, 2);
    }

    private BigDecimal validateDepositAndReturn(
            BigDecimal depositAmount,
            String nullMessage,
            String negativeMessage
    ) {
        BigDecimal nonNullDepositAmount =
                ValueValidator.checkForNullValueAndReturn(depositAmount, nullMessage);
        return ValueValidator.checkForNegativeValueAndReturn(nonNullDepositAmount, negativeMessage);
    }

    private BigDecimal validateWithdrawAndReturn(
            BigDecimal withdrawAmount,
            String nullMessage,
            String negativeMessage
    ) {
        BigDecimal nonNullWithdrawAmount =
                ValueValidator.checkForNullValueAndReturn(withdrawAmount, nullMessage);
        return ValueValidator.checkForNegativeValueAndReturn(nonNullWithdrawAmount, negativeMessage);
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
                nonNullBalance,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage()
        );
   }
}
