package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {

    private Burger burger;

    @BeforeEach
    public void setUp() {
        burger = new Burger(
            BurgerName.GROUND_HAMBURGER,
            BurgerType.MEDIUM,
            new BigDecimal("2.55")
        );
    }

    @Nested
    @DisplayName("test get meat type")
    class TestGetAndSetBurgerMeatType {

        @Test
        public void testGetBurgerMeatType() {
            assertEquals(BurgerName.GROUND_HAMBURGER, burger.getName());
        }
    }

    @Nested
    @DisplayName("test get and set burger size")
    class TestGetAndSetBurgerSize {

        @Test
        public void testGetBurgerMeatSize() {
            assertEquals(BurgerType.MEDIUM, burger.getType());
        }
    }

    @Nested
    @DisplayName("test get and set burger price")
    class TestGetAndSetBurgerPrice {

        @Test
        public void testGetBurgerPrice() {
            assertEquals(new BigDecimal("2.55"), burger.getPrice());
        }
    }

    @Nested
    @DisplayName("test burger to string")
    class TestBurgerToStringMethod {

        @Test
        public void testToStringMethod() {
            String expected = """
                Burger:
                Name: GROUND_HAMBURGER
                Type: MEDIUM
                Price: $2.55
                """;
            String result = burger.toString();

            assertEquals(expected, result);
        }
    }
}
