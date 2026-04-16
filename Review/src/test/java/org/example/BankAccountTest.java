package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Capital One",
                12345678, BigDecimal.valueOf(512.3578));
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345678, bankAccount.getAccountNumber());
    }

    @Test
    public void testBankNameRejectsNull() {
        assertEquals(
                "Null value not allowed for bank name",
                assertThrows(
                NullPointerException.class,
                () -> new BankAccount(null, 12345,
                BigDecimal.valueOf(512.3578))
            ).getMessage()
        );
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
    public void testConstructorRejectsNegativeAccountNumber() {
        assertEquals(
            "Account number is less than zero",
            assertThrows(
            IllegalArgumentException.class,
            () -> new BankAccount("Capital One", -12345,
            BigDecimal.valueOf(512.3578))
            ).getMessage()
        );
    }

    @Test
    public void testConstructorRejectsNullBalance() {
        assertEquals(
                "Null value not allowed for balance",
                assertThrows(
                        NullPointerException.class,
                        () -> new BankAccount( "Capital One", 12345678, null)
            ).getMessage()
        );
    }

    @Test
    public void testConstructorRejectsNegativeBalance() {
        assertEquals(
                "Balance is less than zero",
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
                "Null value not allowed for deposit amount",
                assertThrows(
                NullPointerException.class,
                () ->  bankAccount.deposit(null)
            ).getMessage()
        );
    }

    @Test
    public void testDepositRejectsNegativeAmount() {
        assertEquals(
                "Deposit amount cannot be less than zero",
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
    public void testZeroDepositLeavesBalanceUnchanged() {
        bankAccount.deposit(BigDecimal.valueOf(0.00));
        assertEquals(BigDecimal.valueOf(512.36), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawRejectsNullValue() {
        assertEquals(
                "Null value not allowed for withdraw amount",
                assertThrows(
                NullPointerException.class,
                () ->  bankAccount.withdraw(null)
            ).getMessage()
        );
    }

    @Test
    public void testWithdrawRejectsExceedingBalance() {
        assertEquals(
                "Insufficient funds",
                assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
            ).getMessage()
        );
    }

    @Test
    public void testWithdrawRejectsNegativeAmount() {
        assertEquals(
                "Withdraw amount cannot be less than zero",
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
}
