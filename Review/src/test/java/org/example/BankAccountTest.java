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
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new BankAccount(null, 12345,
                        BigDecimal.valueOf(512.3578))
        );
        assertEquals("Null value not allowed for bank name", thrown.getMessage());
    }

    @Test
    public void testGetAndSetBankName() {
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
        assertThrows(
                NullPointerException.class,
                () ->  bankAccount.deposit(null)
        );
    }

    @Test
    public void testDepositRejectsNegativeAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.deposit( BigDecimal.valueOf(-512.3578))
        );
    }

    @Test
    public void testDepositRoundsDownBalance() {
        bankAccount.deposit(BigDecimal.valueOf(434.7649));
        assertEquals(BigDecimal.valueOf(947.12), bankAccount.getBalance());
    }

    @Test
    public void testDepositRoundsUpBalance() {
        bankAccount.deposit(BigDecimal.valueOf(434.765));
        assertEquals(BigDecimal.valueOf(947.13), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawRejectsNullValue() {
        assertThrows(
                NullPointerException.class,
                () ->  bankAccount.withdraw(null)
        );
    }

    @Test
    public void testWithdrawRejectsExceedingBalance() {
        assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
        );
    }

    @Test
    public void testWithdrawRejectsNegativeAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(-300.45))
        );
    }

    @Test
    public void testWithdrawRoundsDownBalance() {
        bankAccount.withdraw(BigDecimal.valueOf(121.789));
        assertEquals(BigDecimal.valueOf(390.57), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawRoundsUpBalance() {
        bankAccount.withdraw(BigDecimal.valueOf(99.991));
        assertEquals(BigDecimal.valueOf(412.37), bankAccount.getBalance());
    }

    @Test
    public void testStandardTwoDecimalWithdraw() {
        bankAccount.withdraw(BigDecimal.valueOf(224.57));
        assertEquals(BigDecimal.valueOf(287.79), bankAccount.getBalance());
    }
}
