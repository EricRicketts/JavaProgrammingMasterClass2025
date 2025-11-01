package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount();
        bankAccount.setAccountNumber(12345);
        bankAccount.setBalance(500);
        bankAccount.setCustomerName("John Silver");
        bankAccount.setCustomerEmail("john.silver@example.com");
        bankAccount.setCustomerPhone("9194491234");
    }

    @Test
    public void getterAndSetterTestForAccountNumber() {
        bankAccount.setAccountNumber(67890);
        Assertions.assertEquals(67890, bankAccount.getAccountNumber());
    }

    @Test
    public void getterAndSetterTestForBalance() {
        bankAccount.setBalance(734);
        Assertions.assertEquals(734, bankAccount.getBalance());
    }

    @Test
    public void getterAndSetterTestForCustomerName() {
        bankAccount.setCustomerName("Jane Doe");
        Assertions.assertEquals("Jane Doe", bankAccount.getCustomerName());
    }

    @Test
    public void getterAndSetterTestForCustomerEmail() {
        bankAccount.setCustomerEmail("jane.doe@example.com");
        Assertions.assertEquals("jane.doe@example.com", bankAccount.getCustomerEmail());
    }

    @Test
    public void getterAndSetterTestForCustomerPhone() {
        bankAccount.setCustomerPhone("7034510987");
        Assertions.assertEquals("7034510987", bankAccount.getCustomerPhone());
    }

    @Test
    public void depositFundsTest() {
        bankAccount.depositFunds(500);
        Assertions.assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void withdrawFundsTest() {
        bankAccount.withdrawFunds(250);
        Assertions.assertEquals(250, bankAccount.getBalance());
    }

    @Test
    public void tooManyFundsWithdrawnTest() {
        bankAccount.withdrawFunds(700);
        Assertions.assertEquals(
                "Withdraw denied balance less than zero", bankAccount.getWithdrawError());
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test
    public void noArgsConstructorTest() {
        bankAccount = new BankAccount();
        Assertions.assertEquals(0, bankAccount.getAccountNumber());
        Assertions.assertEquals(0.00, bankAccount.getBalance());
        Assertions.assertEquals("Default name", bankAccount.getCustomerName());
        Assertions.assertEquals("Default email", bankAccount.getCustomerEmail());
        Assertions.assertEquals("Default phone", bankAccount.getCustomerPhone());
    }

    @Test
    public void argsConstructorTest() {
        bankAccount = new BankAccount(12345, 134.55, "Billy Bob",
                "billy.bob@example.com", "(980) 123-4567");
        Assertions.assertEquals(12345, bankAccount.getAccountNumber());
        Assertions.assertEquals(134.55, bankAccount.getBalance());
        Assertions.assertEquals("Billy Bob", bankAccount.getCustomerName());
        Assertions.assertEquals("billy.bob@example.com", bankAccount.getCustomerEmail());
        Assertions.assertEquals("(980) 123-4567", bankAccount.getCustomerPhone());
    }
}
