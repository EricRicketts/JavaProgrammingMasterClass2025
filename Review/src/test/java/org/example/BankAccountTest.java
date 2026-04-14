package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bankAccount;
    private IllegalArgumentException thrownIllegalArgument;
    private NullPointerException thrownNullPointer;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Capital One",
                12345678, BigDecimal.valueOf(512.3578));
    }

    @Test
    public void testGetBalance() {
        assertEquals(0, BigDecimal.valueOf(512.36).compareTo(bankAccount.getBalance()));
    }

    @Test
    public void testNegativeAccountNumber() {
        thrownIllegalArgument = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", -12345,
                        BigDecimal.valueOf(512.3578))
        );
        assertEquals("Account number is less than zero", thrownIllegalArgument.getMessage());
    }

    @Test
    public void testNegativeBalance() {
        thrownIllegalArgument = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", 12345,
                        BigDecimal.valueOf(-512.3578))
        );
        assertEquals("Balance is less than zero", thrownIllegalArgument.getMessage());
    }

    @Test
    public void testNullBankName() {
        thrownNullPointer = assertThrows(
                NullPointerException.class,
                () -> new BankAccount(null, 12345,
                        BigDecimal.valueOf(512.3578))
        );
        assertEquals("Null value not allowed for bank name", thrownNullPointer.getMessage());
    }

    @Test
    public void testDepositRoundDown() {
        bankAccount.deposit(BigDecimal.valueOf(434.7649));
        assertEquals(BigDecimal.valueOf(947.12), bankAccount.getBalance());
    }

    @Test
    public void testDepositRoundUp() {
        bankAccount.deposit(BigDecimal.valueOf(434.765));
        assertEquals(BigDecimal.valueOf(947.13), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawTooBig() {
        thrownIllegalArgument = assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.withdraw(BigDecimal.valueOf(540.87))
        );
        assertEquals("Insufficient Funds", thrownIllegalArgument.getMessage());
    }

    @Test
    public void testWithdrawRoundDown() {
        bankAccount.withdraw(BigDecimal.valueOf(121.789));
        assertEquals(BigDecimal.valueOf(390.57), bankAccount.getBalance());
    }
}
