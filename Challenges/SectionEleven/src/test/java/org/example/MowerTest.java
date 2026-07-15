package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerTest {

    private Mower mower;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Mower for cutting grass";
        mower = new Mower("Mower", description, new BigDecimal("319.99"));
    }

    @Nested
    @DisplayName("test Mower getters")
    class TestMowerGetters {

        @Test
        public void testMowerGetType() {
            assertEquals("Mower", mower.getType());
        }

        @Test
        public void testMowerGetDescription() {
            assertEquals("Battery powered Mower for cutting grass", mower.getDescription());
        }

        @Test
        public void testMowerGetPrice() {
            assertEquals(new BigDecimal("319.99"), mower.getPrice());
        }
    }

    @Nested
    @DisplayName("test Mower setters")
    class TestMowerSetters {

        @Test
        public void testMowerSetPrice() {
            assertEquals(new BigDecimal("319.99"), mower.getPrice());
            mower.setPrice(new BigDecimal("339.99"));

            assertEquals(new BigDecimal("339.99"), mower.getPrice());
        }
    }

    @Nested
    @DisplayName("test Mower getSalesPrice method")
    class TestMowerSalesPrice {

        @Test
        public void testMowerSalesPrice() {
            BigDecimal expected = new BigDecimal("1279.96");
            BigDecimal result = mower.getSalesPrice(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Mower printPricedItem method")
    class TestMowerPrintPricedItem {

        @Test
        public void testMowerPrintPricedItem() {
            String expected = "Item Quantity: 4 Item Type: Mower Total Price: 1279.96";
            String result = mower.printPricedItem(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Mower showDetails Method")
    class TestMowerShowDetails {

        @Test
        public void testMowerShowDetailsMethod() {
            String expected = "Type: Mower\nPrice: 319.99\nDescription: Battery powered Mower for cutting grass\n";
            String result = mower.showDetails();

            assertEquals(expected, result);
        }
    }
}
