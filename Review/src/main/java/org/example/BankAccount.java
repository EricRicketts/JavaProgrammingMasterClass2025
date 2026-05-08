package org.example;

import java.math.BigDecimal;
import java.util.regex.Pattern;

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
        BigDecimal validDepositAmount = ValueValidator.validateDepositAndReturn(depositAmount);
        this.balance = NumberUtils.setScale(this.balance.add(validDepositAmount), 2);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        BigDecimal validWithdrawAmount = ValueValidator.validateWithdrawAndReturn(withdrawAmount);

        this.balance = ensureNonNegativeBalanceAfterWithdraw(
                NumberUtils.setScale(this.balance.subtract(validWithdrawAmount), 2),
                ErrorMessages.INSUFFICIENT_FUNDS_MESSAGE_FOR_WITHDRAW.getErrorMessage()
        );
    }

    /*
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

     */


    private BigDecimal ensureNonNegativeBalanceAfterWithdraw(BigDecimal newBalance, String message) {
        return ValueValidator.checkForNegativeValueAndReturn(newBalance, message);
    }

   private String validateBankNameAndReturn(String bankName) {
        final Pattern ONE_OR_MORE_SPACES = Pattern.compile("\\s+");
        final String EMPTY_STRING = "";

        return switch(bankName) {
            case null -> throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
            case EMPTY_STRING -> throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
            case String s when ONE_OR_MORE_SPACES.matcher(s).matches() -> throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage()
            );
            default -> bankName;
       };
   }

   private int validateAccountNumberAndReturn(int accountNumber) {
        if (accountNumber == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
            );
        } else if (accountNumber < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage()
            );
        } else {
            return accountNumber;
        }
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
