package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Capital One",
                12345678, BigDecimal.valueOf(512.3578));
    }

    @Nested
    @DisplayName("Constructor checks for bank name, account number and balance")
    class BankAccountConstructorChecks {

        @Nested
        @DisplayName("Constructor checks for bank name")
        class  BankAccountConstructorChecksForBankName {

            @Test
            public void testConstructorRejectsNullBankName() {
                assertEquals(
                        ErrorMessages.NULL_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage(),
                        assertThrows(
                                NullPointerException.class,
                                () -> new BankAccount(null, 12345,
                                        BigDecimal.valueOf(512.3578))
                        ).getMessage()
                );
            }

            @Test
            public void testConstructorRejectsEmptyBankName() {
                assertEquals(
                        ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage(),
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new BankAccount("", 12345,
                                        BigDecimal.valueOf(512.3578))
                        ).getMessage()
                );
            }

            @Test
            public void testConstructorRejectsBlankBankName() {
                assertEquals(
                        ErrorMessages.BLANK_VALUE_MESSAGE_FOR_BANK_NAME.getErrorMessage(),
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new BankAccount("  ", 12345,
                                        BigDecimal.valueOf(512.3578))
                        ).getMessage()
                );
            }
        }

        @Nested
        @DisplayName("Constructor checks for account number")
        class BankAccountConstructorChecksForAccountNumber {

            @Test
            public void testConstructorRejectsZeroAccountNumber() {
                assertEquals(
                        ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage(),
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new BankAccount("Capital One", 0,
                                        BigDecimal.valueOf(512.3578))
                        ).getMessage()
                );
            }

            @Test
            public void testConstructorRejectsNegativeAccountNumber() {
                assertEquals(
                        ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ACCOUNT_NUMBER.getErrorMessage(),
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new BankAccount("Capital One", -12345,
                                        BigDecimal.valueOf(512.3578))
                        ).getMessage()
                );
            }
        }

        @Nested
        @DisplayName("Constructor checks for balance")
        class BankAccountConstructorChecksForBalance {

            @Test
            public void testConstructorRejectsNullBalance() {
                assertEquals(
                        ErrorMessages.NULL_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage(),
                        assertThrows(
                                NullPointerException.class,
                                () -> new BankAccount(
                                        "Capital One",
                                        123456,
                                        null)
                        ).getMessage()
                );
            }
        }
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345678, bankAccount.getAccountNumber());
    }


    @Test
    public void testGetBankName() {
        assertEquals("Capital One", bankAccount.getBankName());
    }


    @Test
    public void testGetBalance() {
        assertEquals(0, BigDecimal.valueOf(512.36).compareTo(bankAccount.getBalance()));
    }


    @Test
    public void testConstructorRejectsNullBalance() {
        assertEquals(
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage(),
                assertThrows(
                        NullPointerException.class,
                        () -> new BankAccount( "Capital One", 12345678, null)
            ).getMessage()
        );
    }

    @Test
    public void testConstructorRejectsNegativeBalance() {
        assertEquals(
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage(),
                assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", 12345,
                BigDecimal.valueOf(-512.3578))
            ).getMessage()
        );
    }

    @Test
    public void testDepositRejectsNullValue() {
        assertEquals(
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage(),
                assertThrows(
                NullPointerException.class,
                () ->  bankAccount.deposit(null)
            ).getMessage()
        );
    }

    @Test
    public void testDepositRejectsNegativeAmount() {
        assertEquals(
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage(),
                assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.deposit( BigDecimal.valueOf(-512.3578))
            ).getMessage()
        );
    }

    @Test
    public void testDepositIncreasesBalanceAndRoundsForThreeDecimalPlaces() {
        bankAccount.deposit(BigDecimal.valueOf(100.505));
        assertEquals(BigDecimal.valueOf(612.87), bankAccount.getBalance());
    }

    @Test
    public void testDepositAndWithdrawSmallestPracticalAmount() {
        bankAccount.deposit(BigDecimal.valueOf(0.01));
        assertEquals(BigDecimal.valueOf(512.37), bankAccount.getBalance());
        bankAccount.withdraw(BigDecimal.valueOf(0.01));
        assertEquals(BigDecimal.valueOf(512.36), bankAccount.getBalance());
    }

    @Test
    public void testDepositAndWithdrawLargePracticalAmount() {
        bankAccount.deposit(BigDecimal.valueOf(1_500_000.00));
        assertEquals(BigDecimal.valueOf(1_500_512.36), bankAccount.getBalance());
        bankAccount.withdraw(BigDecimal.valueOf(1_000_000.00));
        assertEquals(BigDecimal.valueOf(500_512.36), bankAccount.getBalance());
    }

    @Test
    public void testZeroDepositLeavesBalanceUnchanged() {
        bankAccount.deposit(BigDecimal.valueOf(0.00));
        assertEquals(BigDecimal.valueOf(512.36), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawRejectsNullValue() {
        assertEquals(
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                assertThrows(
                NullPointerException.class,
                () ->  bankAccount.withdraw(null)
            ).getMessage()
        );
    }

    @Test
    public void testWithdrawRejectsExceedingBalance() {
        assertEquals(
                ErrorMessages.INSUFFICIENT_FUNDS_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
            ).getMessage()
        );
    }

    @Test
    public void testWithdrawRejectsNegativeAmount() {
        assertEquals(
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(-300.45))
            ).getMessage()
        );
    }

    @Test
    public void testZeroWithdrawLeaveBalanceUnchanged() {
        bankAccount.withdraw(BigDecimal.valueOf(0.00));
        assertEquals(BigDecimal.valueOf(512.36), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalanceAndRoundsForThreeDecimalPlaces() {
        bankAccount.withdraw(BigDecimal.valueOf(89.974));
        assertEquals(BigDecimal.valueOf(422.39), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawEqualToBalanceLeavesZeroBalance() {
        bankAccount.withdraw(BigDecimal.valueOf(512.36));
        BigDecimal zero = new BigDecimal("0");
        BigDecimal formattedZero = zero.setScale(2, RoundingMode.HALF_UP);
        assertEquals(formattedZero, bankAccount.getBalance());
    }
}
