package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account, bobsAccount;

    @BeforeEach
    public void setUp() {
        account = new Account();
        account.setBalance(100);
        account.setAccountHolder("John Doe");
        account.setEmail("john.doe@example.com");
        account.setPhoneNumber("123-456-7890");

        bobsAccount = new Account(
                "12345", 1000.00,
                "Bob Brown", "bob.brown@example.com",
                "(919) 449-1290");
    }

    @Test
    public void testNonBalanceFields() {
        String[] expected = {"John Doe", "john.doe@example.com", "123-456-7890"};
        String[] results = {
                account.getAccountHolder(), account.getEmail(), account.getPhoneNumber()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testDeposit() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testOverdraw() {
        String result = account.withdraw(300);
        assertEquals("Insufficient Funds", result);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testConstructorForBobsAccount() {
        String[] expected = {
                "Bob Brown", "bob.brown@example.com", "12345",
                "(919) 449-1290", "1000.00"
        };
        String[] result = {
                bobsAccount.getAccountHolder(), bobsAccount.getEmail(),
                bobsAccount.getAccountNumber(), bobsAccount.getPhoneNumber(),
                String.format("%.2f", bobsAccount.getBalance())
        };
        assertArrayEquals(expected, result);
    }

}
