package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Chase");
    }

    @Nested
    @DisplayName("test adding new customers to bank")
    class TestAddNewCustomersToBank {

        @Test
        public void testAddNewCustomer() {
            assertEquals(0, bank.getCustomers().size());

            bank.addNewCustomer("John Doe", 500.00);
            assertEquals(1, bank.getCustomers().size());
        }

        @Test
        public void testCannotAddDuplicateCustomer() {
            assertEquals(0, bank.getCustomers().size());

            bank.addNewCustomer("John Doe", 500.00);
            assertEquals(1, bank.getCustomers().size());

            bank.addNewCustomer("John Doe", 300.00);
            assertEquals(1, bank.getCustomers().size());
        }
    }

    @Nested
    @DisplayName("test add transactions through bank")
    class TestAddTransactionsThroughBank {

        @Test
        public void testAddTwoTransactions() {
            bank.addNewCustomer("John Doe", 500.12);
            bank.addTransactions("John Doe", 694.34);

            assertEquals(Double.valueOf(500.12), bank.getCustomers().getFirst().transactions().getFirst());
            assertEquals(Double.valueOf(694.34), bank.getCustomers().getFirst().transactions().get(1));
        }
    }
}
