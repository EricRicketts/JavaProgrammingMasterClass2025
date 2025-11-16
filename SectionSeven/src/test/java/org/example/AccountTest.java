package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AccountTest {
    Account account;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setup() {
        account = new Account();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testDeposit() {
        Assertions.assertEquals(235.45, account.getBalance());
        account.deposit(1.10);
        double result = Math.round(account.getBalance() * 100.0) / 100.0;
        Assertions.assertEquals(236.55, result);
    }

    @Test
    public void testWithdraw() {
        Assertions.assertEquals(235.45, account.getBalance());
        account.withdraw(1.57);
        Assertions.assertEquals(233.88, account.getBalance());
    }

    @Test
    public void testInsufficientFunds() {
        Assertions.assertEquals(235.45, account.getBalance());
        account.withdraw(300.00);
        Assertions.assertEquals("Insufficient Funds\n", outContent.toString());
        Assertions.assertEquals(235.45, account.getBalance());
    }
}
