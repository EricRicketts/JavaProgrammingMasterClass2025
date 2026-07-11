package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 1000.00);
    }

    @Test
    public void testCustomerName() {
        assertEquals("JOHN DOE", customer.name());
    }

    @Test
    public void testInitialCustomerDeposit() {
        Double expected = 1000.00;
        assertEquals(expected, customer.transactions().getFirst());
    }
}
