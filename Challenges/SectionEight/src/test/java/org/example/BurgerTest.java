package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {

    Burger smallBurger, mediumBurger, largeBurger, defaultBurger;

    Topping expectedTopping, resultantTopping;
    String[] expectedTypes, resultantTypes;
    BigDecimal[] expectedPrices, resultantPrices;

    @BeforeEach
    public void setUp() {
        smallBurger = new Burger("small", new BigDecimal("15.00"));
        mediumBurger = new Burger("medium", new BigDecimal("15.00"));
        largeBurger = new Burger("large", new BigDecimal("15.00"));
        defaultBurger = new Burger("default burger", new BigDecimal("13.00"));
    }

    @Test
    public void testAllBurgers() {
        expectedTypes = new String[]{"small", "medium", "large", "regular"};
        expectedPrices = new BigDecimal[]{
            new BigDecimal("6.00"),
            new BigDecimal("15.00"),
            new BigDecimal("25.00"),
            new BigDecimal("12.00")
        };
        for (int i = 0; i < expectedTypes.length; i++) {
            BigDecimal priceSlot = new BigDecimal("12.00");
            String type = expectedTypes[i];
            Burger burger = new Burger(type, priceSlot);
            BigDecimal expectedPrice = new BigDecimal(String.valueOf(expectedPrices[i]));
            assertEquals(type, burger.getType());
            assertEquals(expectedPrice, burger.getPrice());
        }
    }

    @Test
    public void testSetToppingOnABurger() {
        String[] toppingTypes = new String[]{"lettuce", "tomatoes", "cheese"};
        BigDecimal[] expectedPrices = new BigDecimal[]{
            new BigDecimal("1.00"),
            new BigDecimal("1.50"),
            new BigDecimal("2.00")
        };
        for (int i = 0; i < 3; i++) {
            largeBurger.addTopping(toppingTypes[i]);
        }
        for (int i = 0; i < 3; i++) {
            Topping topping = largeBurger.getToppings().get(i);
            assertEquals(toppingTypes[i], topping.getType());
            assertEquals(expectedPrices[i], topping.getPrice());
        }
    }

    @Nested
    @DisplayName("test small burger")
    class TestSmallBurger {

        @Test
        public void testSmallBurgerType() {
            assertEquals("small", smallBurger.getType());
        }

        @Test
        public void testSmallBurgerGetPrice() {
            assertEquals(new BigDecimal("6.00"), smallBurger.getPrice());
        }
    }

    @Nested
    @DisplayName("test medium burger")
    class TestMediumBurger {

        @Test
        public void testMediumBurgerType() {
            assertEquals("medium", mediumBurger.getType());
        }

        @Test
        public void testMediumBurgerGetPrice() {
            assertEquals(new BigDecimal("15.00"), mediumBurger.getPrice());
        }
    }

    @Nested
    @DisplayName("test large burger")
    class TestLargeBurger {

        @Test
        public void testLargeBurgerType() {
            assertEquals("large", largeBurger.getType());
        }

        @Test
        public void testLargeBurgerGetPrice() {
            assertEquals(new BigDecimal("25.00"), largeBurger.getPrice());
        }
    }

    @Nested
    @DisplayName("test default burger")
    class TestDefaultBurger {

        @Test
        public void testMediumBurgerType() {
            assertEquals("default burger", defaultBurger.getType());
        }

        @Test
        public void testMediumBurgerGetPrice() {
            assertEquals(new BigDecimal("13.00"), defaultBurger.getPrice());
        }
    }

    @Nested
    @DisplayName("test get burger type and price")
    class TestGetBurgerTypeAndPrice {

        @Test
        public void testGetBurgerType() {
            assertEquals("medium", mediumBurger.getType());
        }

        @Test
        public void testGetBurgerPrice() {
            assertEquals(new BigDecimal("25.00"), largeBurger.getPrice());
        }
    }

    @Nested
    @DisplayName("test add burger toppings")
    class TestBurgerToppings {

        @BeforeEach
        public void setUp() {
            List<String> toppings = new ArrayList<String>(List.of(
                "lettuce",
                "tomatoes",
                "cheese"
            ));
            for (String topping : toppings) {
                defaultBurger.addTopping(topping);
            }
        }

        @Test
        public void testNumberOfToppingsAdded() {
            assertEquals(3, defaultBurger.getToppings().size());
        }

        @Test
        public void testFirstToppingAdded() {

            assertEquals(new Topping("lettuce"), defaultBurger.getToppings().getFirst());
        }

        @Test
        public void testSecondToppingAdded() {
            assertEquals(new Topping("tomatoes"), defaultBurger.getToppings().get(1));
        }

        @Test
        public void testThirdToppingAdded() {
            assertEquals(new Topping("cheese"), defaultBurger.getToppings().getLast());
        }
    }
}
