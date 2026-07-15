package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlowerTest {

    private Blower blower;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Blower for lawns";
        blower = new Blower("Blower", description, new BigDecimal("239.99"));
    }

    @Nested
    @DisplayName("test Blower getters")
    class TestBlowerGetters {

        @Test
        public void testBlowerGetType() {
            assertEquals("Blower", blower.getType());
        }

        @Test
        public void testBlowerGetDescription() {
            assertEquals("Battery powered Blower for lawns", blower.getDescription());
        }

        @Test
        public void testBlowerGetPrice() {
            assertEquals(new BigDecimal("239.99"), blower.getPrice());
        }
    }

    @Nested
    @DisplayName("test Blower setters")
    class TestBlowerSetters {

        @Test
        public void testBlowerSetPrice() {
            assertEquals(new BigDecimal("239.99"), blower.getPrice());
            blower.setPrice(new BigDecimal("259.99"));

            assertEquals(new BigDecimal("259.99"), blower.getPrice());
        }
    }

    @Nested
    @DisplayName("test Blower getSalesPrice method")
    class TestBlowerSalesPrice {

        @Test
        public void testBlowerSalesPrice() {
            BigDecimal expected = new BigDecimal("959.96");
            BigDecimal result = blower.getSalesPrice(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Blower printPricedItem method")
    class TestBlowerPrintPricedItem {

        @Test
        public void testBlowerPrintPricedItem() {
            String expected = "Item Quantity: 4 Item Type: Blower Total Price: 959.96";
            String result = blower.printPricedItem(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Blower showDetails Method")
    class TestBlowerShowDetails {

        @Test
        public void testBlowerShowDetailsMethod() {
            String expected = "Type: Blower Price: 239.99 Description: Battery powered Blower for lawns";
            String result = blower.showDetails();

            assertEquals(expected, result);
        }
    }
}
