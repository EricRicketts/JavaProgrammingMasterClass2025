package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account;

    @BeforeEach
    public void setup() {
        account = new Account();
        account.setAccountNumber(12345);
        account.setBalance(500);
        account.setCustomerName("John Silver");
        account.setCustomerEmail("john.silver@example.com");
        account.setCustomerPhone("9194491234");
    }

    @Test
    public void getterAndSetterTestForAccountNumber() {
        account.setAccountNumber(67890);
        Assertions.assertEquals(67890, account.getAccountNumber());
    }

    @Test
    public void getterAndSetterTestForBalance() {
        account.setBalance(734);
        Assertions.assertEquals(734, account.getBalance());
    }

    @Test
    public void getterAndSetterTestForCustomerName() {
        account.setCustomerName("Jane Doe");
        Assertions.assertEquals("Jane Doe", account.getCustomerName());
    }

    @Test
    public void getterAndSetterTestForCustomerEmail() {
        account.setCustomerEmail("jane.doe@example.com");
        Assertions.assertEquals("jane.doe@example.com", account.getCustomerEmail());
    }

    @Test
    public void getterAndSetterTestForCustomerPhone() {
        account.setCustomerPhone("7034510987");
        Assertions.assertEquals("7034510987", account.getCustomerPhone());
    }

    @Test
    public void depositFundsTest() {
        account.depositFunds(500);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void withdrawFundsTest() {
        account.withdrawFunds(250);
        Assertions.assertEquals(250, account.getBalance());
    }

    @Test
    public void tooManyFundsWithdrawnTest() {
        account.withdrawFunds(700);
        Assertions.assertEquals(
                "Withdraw denied balance less than zero", account.getWithdrawError());
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void noArgsConstructorTest() {
        account = new Account();
        Assertions.assertEquals(0, account.getAccountNumber());
        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals("Default name", account.getCustomerName());
        Assertions.assertEquals("Default email", account.getCustomerEmail());
        Assertions.assertEquals("Default phone", account.getCustomerPhone());
    }

    @Test
    public void argsConstructorTest() {
        account = new Account(12345, 134.55, "Billy Bob",
                "billy.bob@example.com", "(980) 123-4567");
        Assertions.assertEquals(12345, account.getAccountNumber());
        Assertions.assertEquals(134.55, account.getBalance());
        Assertions.assertEquals("Billy Bob", account.getCustomerName());
        Assertions.assertEquals("billy.bob@example.com", account.getCustomerEmail());
        Assertions.assertEquals("(980) 123-4567", account.getCustomerPhone());
    }
}
