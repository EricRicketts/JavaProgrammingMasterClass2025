package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {

    @Nested
    @DisplayName("test lettuce name and price")
    class TestLettuceNameAndPrice {

        @Test
        public void testLettuceToppingName() {
            assertEquals("LETTUCE", Topping.LETTUCE.name());
        }

        @Test
        public void testLettuceToppingPrice() {
            assertEquals(new BigDecimal("1.50"), Topping.LETTUCE.getPrice());
        }
    }

    @Nested
    @DisplayName("test tomato name and price")
    class TestTomatoNameAndPrice {

        @Test
        public void testTomatoToppingName() {
            assertEquals("TOMATO", Topping.TOMATO.name());
        }

        @Test
        public void testLettuceToppingPrice() {
            assertEquals(new BigDecimal("2.50"), Topping.TOMATO.getPrice());
        }
    }

    @Nested
    @DisplayName("test onion name and price")
    class TestOnionNameAndPrice {

        @Test
        public void testOnionToppingName() {
            assertEquals("ONION", Topping.ONION.name());
        }

        @Test
        public void testOnionToppingPrice() {
            assertEquals(new BigDecimal("1.00"), Topping.ONION.getPrice());
        }
    }

    @Nested
    @DisplayName("test relish name and price")
    class TestRelishNameAndPrice {

        @Test
        public void testRelishToppingName() {
            assertEquals("RELISH", Topping.RELISH.name());
        }

        @Test
        public void testLettuceToppingPrice() {
            assertEquals(new BigDecimal("0.75"), Topping.RELISH.getPrice());
        }
    }
}
