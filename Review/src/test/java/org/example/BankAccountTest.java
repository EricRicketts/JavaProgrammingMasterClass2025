package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Capital One", 12345678, 512.3578);
    }

    @Test
    public void testGetBalance() {
        assertEquals(512.36, bankAccount.getBalance());
    }

    @Test
    public void testNegativeAccountNumber() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", -12345, 512.3578)
        );
        assertEquals("Account number is less than zero", thrown.getMessage());
    }

    @Test
    public void testNegativeBalance() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("Capital One", 12345, -512.3578)
        );
        assertEquals("Balance is less than zero", thrown.getMessage());
    }
}
