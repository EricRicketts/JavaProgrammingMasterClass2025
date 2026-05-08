package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount bankAccount;

    private final String bankNameLiteral = "bank name";

    private final String accountNumberLiteral = "account number";

    private final String balanceLiteral = "balance";

    private final String depositLiteral = "deposit";

    private final String withdrawLiteral = "withdraw";

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
                        ErrorMessages.nullValue(bankNameLiteral),
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
                        ErrorMessages.emptyValue(bankNameLiteral),
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
                        ErrorMessages.blankValue(bankNameLiteral),
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
                        ErrorMessages.zeroValue(accountNumberLiteral),
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
                        ErrorMessages.negativeValue(accountNumberLiteral),
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
                        ErrorMessages.nullValue(balanceLiteral),
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
                        ErrorMessages.negativeValue(balanceLiteral),
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
                    ErrorMessages.nullValue(depositLiteral),
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
                    ErrorMessages.negativeValue(depositLiteral),
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
                    ErrorMessages.nullValue(withdrawLiteral),
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
                    ErrorMessages.negativeValue(withdrawLiteral),
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
                    ErrorMessages.insufficientFunds(withdrawLiteral),
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
    @DisplayName("Bank Account getter tests and toString test")
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

        @Test
        public void testToString() {
            String bankAccountInformation = bankAccount.toString();

            assertTrue(bankAccountInformation.contains("Capital One"));
            assertTrue(bankAccountInformation.contains("12345678"));
            assertTrue(bankAccountInformation.contains("512.36"));
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

    @Nested
    @DisplayName("Bank Account withdraw tests, small, large, zero amounts and three decimal places")
    class BankAccountWithdrawChecks {

        @Test
        public void testWithdrawRoundsUpAndDecreasesBalance() {
            bankAccount.withdraw(BigDecimal.valueOf(54.546));
            assertEquals(
                    BigDecimal.valueOf(457.81),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testWithdrawRoundsDownAndDecreasesBalance() {
            bankAccount.withdraw(BigDecimal.valueOf(54.544));
            assertEquals(
                    BigDecimal.valueOf(457.82),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testSmallWithdrawDecreasesBalance() {
            bankAccount.withdraw(BigDecimal.valueOf(0.01));
            assertEquals(
                    BigDecimal.valueOf(512.35),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testLargeWithdrawDecreasesBalance() {
            bankAccount.withdraw(BigDecimal.valueOf(234.87));
            assertEquals(
                    BigDecimal.valueOf(277.49),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testZeroWithdrawLeavesBalanceUnchanged() {
            bankAccount.withdraw(NumberUtils.setScale(BigDecimal.valueOf(0.00), 2));
            assertEquals(
                    BigDecimal.valueOf(512.36),
                    bankAccount.getBalance()
            );
        }

        @Test
        public void testWithdrawEqualToBalanceLeavesZeroBalance() {
            bankAccount.withdraw(BigDecimal.valueOf(512.36));
            BigDecimal zero = NumberUtils.setScale(BigDecimal.valueOf(0.00), 2);
            assertEquals(
                    zero,
                    bankAccount.getBalance()
            );
        }
    }
}