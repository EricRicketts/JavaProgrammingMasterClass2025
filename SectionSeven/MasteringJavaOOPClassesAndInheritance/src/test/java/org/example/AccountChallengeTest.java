package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountChallengeTest {

    Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
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
        account.setAccountNumber(123456);
        Assertions.assertEquals(123456,account.getAccountNumber());
    }

    @Test
    public void testDepositFunds() {
        account.setAccountBalance(111.45);
        account.depositFunds(55.55);
        Double expected = 167.00;
        Double result = account.getAccountBalance();
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testWithdrawFunds() {
    }
}
