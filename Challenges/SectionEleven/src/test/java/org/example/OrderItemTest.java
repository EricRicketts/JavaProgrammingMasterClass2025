package org.example;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemTest {

    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Edger for lawn";
        ProductForSale productForSale = new Edger("Edger", description, new BigDecimal("219.99"));
        orderItem = new OrderItem(4, productForSale);
    }

    @Nested
    @DisplayName("test OrderItem getters")
    class TestOrderItemGetters {

        @Test
        public void testOrderItemGetQuantity() {
            assertEquals(4, orderItem.getQuantity());
        }

        @Test
        public void testOrderItemGetProductForSale() {
            String description = "Battery powered Edger for lawn";
            ProductForSale edger = new Edger("Edger", description, new BigDecimal("219.99"));

            assertEquals(edger, orderItem.getProductForSale());
        }
    }

    @Nested
    @DisplayName("test OrderItem setters")
    class TestOrderItemSetters {

        @Test
        public void testOrderItemSetQuantity() {
            assertEquals(4, orderItem.getQuantity());
            orderItem.setQuantity(5);

            assertEquals(5, orderItem.getQuantity());
        }

        @Test
        public void testOrderItemSetProductForSale() {
            String description = "Battery powered Edger for lawn";
            ProductForSale edger = new Edger("Edger", description, new BigDecimal("219.99"));

            assertEquals(edger, orderItem.getProductForSale());
            description = "Battery powered Trimmer for lawn";
            ProductForSale trimmer = new Trimmer("Trimmer", description, new BigDecimal("209.99"));
            orderItem.setProductForSale(trimmer);

            assertEquals(trimmer, orderItem.getProductForSale());
        }

    }

}
