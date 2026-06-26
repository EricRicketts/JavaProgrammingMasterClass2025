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

    Burger smallBurger, mediumBurger, largeBurger,
        defaultBurger, firstBurger, secondBurger;

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

            assertEquals(new Topping("cheese"), defaultBurger.getToppings().getFirst());
        }

        @Test
        public void testSecondToppingAdded() {
            assertEquals(new Topping("lettuce"), defaultBurger.getToppings().get(1));
        }

        @Test
        public void testThirdToppingAdded() {
            assertEquals(new Topping("tomatoes"), defaultBurger.getToppings().getLast());
        }
    }

    @Nested
    @DisplayName("test burger equality")
    class TestBurgerEquality {

        @Test
        public void testTwoEqualBurgersWithNoToppings() {
            firstBurger = new Burger("large", new BigDecimal("25.00"));
            secondBurger = new Burger("large", new BigDecimal("25.00"));

            assertEquals(firstBurger, secondBurger);
        }

        @Test
        public void testTwoEqualBurgersWithTheSameToppings() {
            firstBurger = new Burger("large", new BigDecimal("25.00"));
            secondBurger = new Burger("large", new BigDecimal("25.00"));

            List<String> firstToppingList = new ArrayList<>(List.of("lettuce", "tomatoes", "cheese"));
            List<String> secondToppingList = new ArrayList<>(List.of("cheese", "lettuce", "tomatoes"));

            for (int index = 0; index < 3; index++) {
                firstBurger.addTopping(firstToppingList.get(index));
                secondBurger.addTopping(secondToppingList.get(index));
            }

            assertEquals(firstBurger, secondBurger);
        }
    }
}
