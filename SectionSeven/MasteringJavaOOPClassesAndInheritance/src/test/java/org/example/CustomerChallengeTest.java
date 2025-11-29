package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerChallengeTest {

    Customer firstCustomer, secondCustomer, thirdCustomer;
    List<Object> expected, result;

    @BeforeEach
    public void setUp() {
        firstCustomer = new Customer("Bugs Bunny",
                315.45,
                "bugs.bunny@example.com"
        );
        secondCustomer = new Customer();
        thirdCustomer = new Customer("Tasmanian Devil",
                "tasmanian.devil@example.com");
    }

    @Test
    public void testThreeArgumentCustomerConstructor() {
        expected = List.of("Bugs Bunny", 315.45, "bugs.bunny@example.com");
        result = List.of(firstCustomer.getCustomerName(), firstCustomer.getCreditLimit(),
                firstCustomer.getCustomerEmail());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testNoArgumentCustomerConstructor() {
        expected = List.of("Elmer Fudd", 222.22, "elmer.fudd@example.com");
        result = List.of(secondCustomer.getCustomerName(), secondCustomer.getCreditLimit(),
                secondCustomer.getCustomerEmail());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testTwoArgumentCustomerConstructor() {
        expected = List.of("Tasmanian Devil", 222.22, "tasmanian.devil@example.com");
        result = List.of(thirdCustomer.getCustomerName(), thirdCustomer.getCreditLimit(),
                thirdCustomer.getCustomerEmail());
        Assertions.assertEquals(expected, result);
    }
}
