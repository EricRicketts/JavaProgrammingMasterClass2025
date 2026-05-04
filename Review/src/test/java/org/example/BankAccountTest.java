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
            public void testBalanceUnchangedWhenConstructorRejectsNullBalance() {
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
                assertEquals(
                        BigDecimal.valueOf(512.36),
                        bankAccount.getBalance()
                );
            }

            @Test
            public void testBalanceUnchangedWhenConstructorRejectsNegativeBalance() {
                assertEquals(
                        ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_BALANCE.getErrorMessage(),
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new BankAccount(
                                        "Capital One",
                                        123456,
                                        BigDecimal.valueOf(-112.34)
                                )
                        ).getMessage()
                );
                assertEquals(
                        BigDecimal.valueOf(512.36),
                        bankAccount.getBalance()
                );
            }
        }
    }

    @Nested
    @DisplayName("Deposit checks for null and negative values")
    class InvalidDepositChecks {

        @Test
        public void testBalanceUnchangedWhenDepositRejectsNullValue() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () ->  bankAccount.deposit(null)
                    ).getMessage()
            );
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testBalanceUnchangedWhenDepositRejectsNegativeAmount() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_DEPOSIT.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> bankAccount.deposit( BigDecimal.valueOf(-512.3578))
                    ).getMessage()
            );
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }
    }

    @Nested
    @DisplayName("Withdraw checks for null value, negative value and overdraft")
    class InvalidWithdrawChecks {

        @Test
        public void testBalanceUnchangedWhenWithdrawRejectsNullValue() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () ->  bankAccount.withdraw(null)
                    ).getMessage()
            );
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testBalanceUnchangedWhenWithdrawRejectsNegativeAmount() {
            assertEquals(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> bankAccount.withdraw(BigDecimal.valueOf(-300.45))
                    ).getMessage()
            );
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testBalanceUnchangedWhenWithdrawRejectsExceedingBalance() {
            assertEquals(
                    ErrorMessages.INSUFFICIENT_FUNDS_MESSAGE_FOR_WITHDRAW.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
                    ).getMessage()
            );
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }
    }

    @Nested
    @DisplayName("Bank Account getter tests")
    class BankAccountGetterChecks {

        @Test
        public void testGetAccountNumber() {
            assertEquals(
                    12345678,
                    bankAccount.getAccountNumber()
            );
        }


        @Test
        public void testGetBankName() {
            assertEquals(
                    "Capital One",
                    bankAccount.getBankName()
            );
        }


        @Test
        public void testGetBalance() {
            assertEquals(
                    0,
                    BigDecimal.valueOf(512.36).compareTo(bankAccount.getBalance())
            );
        }
    }

    @Nested
    @DisplayName("Deposit tests, test three decimal place deposit, large deposit, small deposit and zero deposit")
    class BankAccountDepositChecks {

        @Test
        public void testDepositRoundsUpAndIncreasesBalance() {
            bankAccount.deposit(BigDecimal.valueOf(100.505));
            assertEquals(
                    BigDecimal.valueOf(612.87),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testDepositRoundsDownAndIncreasesBalance() {
            bankAccount.deposit(BigDecimal.valueOf(100.504));
            assertEquals(
                    BigDecimal.valueOf(612.86),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testSmallDepositIncreasesBalance() {
            bankAccount.deposit(BigDecimal.valueOf(0.01));
            assertEquals(
                    BigDecimal.valueOf(512.37),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testLargeDepositIncreasesBalance() {
            bankAccount.deposit(BigDecimal.valueOf(1_000_000.64));
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(1_000_513.00), 2),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testZeroDepositBalanceUnchanged() {
            bankAccount.deposit(BigDecimal.valueOf(0.00));
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }
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