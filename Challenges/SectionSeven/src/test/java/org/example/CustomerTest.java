package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CustomerTest {

    Customer firstCustomer, secondCustomer, thirdCustomer;
    String[] expected, result;

    @BeforeEach
    public void setUp() {
        firstCustomer = new Customer(
                "Daffy Duck",
                "daffy.duck@looneytunes.com",
                7_500.00
        );
        secondCustomer = new Customer(
                "Foghorn Leghorn",
                "foghorn.leghorn@looneytunes.com"
        );
        thirdCustomer = new Customer();
    }

    @Test
    public void testFirstCustomer() {
        expected = new String[]{"Daffy Duck", "daffy.duck@looneytunes.com", "7500.00"};
        result = new String[]{
                firstCustomer.getName(),
                firstCustomer.getEmail(),
                String.format("%.2f", firstCustomer.getCreditLimit())
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSecondCustomer() {
        expected = new String[]{"Foghorn Leghorn", "foghorn.leghorn@looneytunes.com", "15000.00"};
        result = new String[]{
                secondCustomer.getName(),
                secondCustomer.getEmail(),
                String.format("%.2f", secondCustomer.getCreditLimit())
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThirdCustomer() {
        expected = new String[]{"Elmer Fudd", "elmer.fudd@looneytunes.com", "10000.00"};
        result = new String[]{
                thirdCustomer.getName(),
                thirdCustomer.getEmail(),
                String.format("%.2f", thirdCustomer.getCreditLimit())
        };
        assertArrayEquals(expected, result);
    }
}