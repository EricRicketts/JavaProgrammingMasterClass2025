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
        var thrown = assertThrows(
                NullPointerException.class,
                () -> new BankAccount(null, 12345,
                        BigDecimal.valueOf(512.3578))
        );
        assertEquals("Null value not allowed for bank name", thrown.getMessage());
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
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", -12345,
                        BigDecimal.valueOf(512.3578))
        );
    }

    @Test
    public void testConstructorRejectsNegativeBalance() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", 12345,
                        BigDecimal.valueOf(-512.3578))
        );
    }

    @Test
    public void testDepositRejectsNullValue() {
        var thrown = assertThrows(
                NullPointerException.class,
                () ->  bankAccount.deposit(null)
        );
        assertEquals("Null value not allowed for deposit amount", thrown.getMessage());
    }

    @Test
    public void testDepositRejectsNegativeAmount() {
        var thrown = assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.deposit( BigDecimal.valueOf(-512.3578))
        );
        assertEquals("Deposit amount cannot be less than zero", thrown.getMessage());
    }

    @Test
    public void testDepositIncreasesBalance() {
        bankAccount.deposit(BigDecimal.valueOf(100.50));
        assertEquals(BigDecimal.valueOf(612.86), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawRejectsNullValue() {
        var thrown = assertThrows(
                NullPointerException.class,
                () ->  bankAccount.withdraw(null)
        );
        assertEquals("Null value not allowed for withdraw amount", thrown.getMessage());
    }

    @Test
    public void testWithdrawRejectsExceedingBalance() {
        var thrown = assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
        );
        assertEquals("Insufficient funds", thrown.getMessage());
    }

    @Test
    public void testWithdrawRejectsNegativeAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(-300.45))
        );
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        bankAccount.withdraw(BigDecimal.valueOf(100.50));
        assertEquals(BigDecimal.valueOf(411.86), bankAccount.getBalance());
    }
}
