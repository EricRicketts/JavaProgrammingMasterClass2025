package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AccountChallengeTest {

    Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
        account.setAccountBalance(111.45);
    }

    @Test
    public void testSettersAndGetters() {
        List<String> expected =
                Arrays.asList("John Doe", "john.doe@example.com", "7034519876");
        account.setCustomerName("John Doe");
        account.setCustomerEmail("john.doe@example.com");
        account.setCustomerPhone("7034519876");

        List<String> result =
                Arrays.asList(account.getCustomerName(),
                        account.getCustomerEmail(),
                        account.getCustomerPhone());

        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testAccountNumber() {
        account.setAccountNumber("123456");
        Assertions.assertEquals("123456",account.getAccountNumber());
    }

    @Test
    public void testDepositFunds() {
        account.depositFunds(55.55);
        Double expected = 167.00;
        Double result = account.getAccountBalance();
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testWithdrawFundsSufficientFunds() {
        String result = account.withdrawFunds(11.45);
        String expected = "Successfully Withdrawn";
        Assertions.assertEquals(expected,result);
        Assertions.assertEquals(100.00, account.getAccountBalance());
    }

    @Test
    public void testWithdrawFundsInsufficientFunds() {
        String result = account.withdrawFunds(143.44);
        String expected = "Insufficient Funds";
        Assertions.assertEquals(111.45, account.getAccountBalance());
    }

    @Test
    public void testConstructorWithAllArguments() {
        Account account = new  Account(
                "12233445", 1515.15, "Elmer Fudd",
                "elmer.fudd@example.com", "(989) 123-7654"
        );
        List<String> expected = List.of("12233445", "Elmer Fudd",
                "elmer.fudd@example.com", "(989) 123-7654");
        List<String> result = List.of(account.getAccountNumber(), account.getCustomerName(),
                account.getCustomerEmail(), account.getCustomerPhone());
        Assertions.assertEquals(expected,result);
        Assertions.assertEquals(1515.15, account.getAccountBalance());
    }

    @Test
    public void testNoArgumentsConstructor() {
        account = new Account();
        List<Object> expected = List.of("56789", 2.50, "Default Name",
                "Default Email", "Default Phone");
        List<Object> result = List.of(account.getAccountNumber(), account.getAccountBalance(),
                account.getCustomerName(), account.getCustomerEmail(), account.getCustomerPhone());
        Assertions.assertEquals(expected,result);
    }
}
