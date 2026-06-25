package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {

    Topping lettuce, tomatoes, cheese, defaultTopping;

    @BeforeEach
    public void setUp() {
        lettuce = new Topping("Lettuce");
        tomatoes = new Topping("Tomatoes");
        cheese = new Topping("Cheese");
        defaultTopping = new Topping("Default Topping");
    }

    @Nested
    @DisplayName("test lettuce topping")
    class TestLettuceTopping {

        @Test
        public void testGetLettuceType() {
            assertEquals("lettuce", lettuce.getType());
        }

        @Test
        public void testGetLettucePrice() {
            assertEquals(new BigDecimal("1.00"), lettuce.getPrice());
        }
    }

    @Nested
    @DisplayName("test tomato topping")
    class TestTomatoTopping {

        @Test
        public void testGetTomatoType() {
            assertEquals("tomatoes", tomatoes.getType());
        }

        @Test
        public void testGetTomatoPrice() {
            assertEquals(new BigDecimal("1.50"), tomatoes.getPrice());
        }
    }

    @Nested
    @DisplayName("test cheese topping")
    class TestCheeseTopping {

        @Test
        public void testGetCheeseType() {
            assertEquals("cheese", cheese.getType());
        }

        @Test
        public void testGetCheesePrice() {
            assertEquals(new BigDecimal("2.00"), cheese.getPrice());
        }
    }

    @Nested
    @DisplayName("test default topping")
    class TestDefaultTopping {

        @Test
        public void testGetDefaultToppingType() {
            assertEquals("default topping", defaultTopping.getType());
        }

        @Test
        public void testGetDefaultToppingPrice() {
            assertEquals(new BigDecimal("0.50"), defaultTopping.getPrice());
        }
    }

    @Nested
    @DisplayName("test topping getters")
    public class TestToppingGetters {

        @Test
        public void testToppingGetType() {
            Topping topping = new Topping("lettuce");

            assertEquals("lettuce", topping.getType());
        }

        @Test
        public void testToppingGetPrice() {
            Topping topping = new Topping("cheese");

            assertEquals(new BigDecimal("2.00"), topping.getPrice());
        }
    }
}
